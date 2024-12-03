package com.devkraken.mytest.features.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devkraken.mytest.R
import com.devkraken.mytest.databinding.FragmentMyListBinding
import com.devkraken.mytest.Item

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MyListFragment : Fragment(R.layout.fragment_my_list) {
    private lateinit var myListViewModel: MyListViewModel
    private lateinit var binding: FragmentMyListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myListViewModel = MyListViewModel()
        myListViewModel.initDataBase(requireContext())
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_MyListFragment_to_addFragment)

        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
    }
}