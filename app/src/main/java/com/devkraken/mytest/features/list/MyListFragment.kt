package com.devkraken.mytest.features.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devkraken.mytest.R
import com.devkraken.mytest.databinding.FragmentMyListBinding

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
        myListViewModel = MyListViewModel(requireContext())
        myListViewModel.allItems.observe(viewLifecycleOwner, { list ->
            binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
            binding.recyclerView.adapter = ItemAdapter(
                data = list,
                onDelete = { item ->
                    myListViewModel.deleteItem(item)
                },
                onUpdate = { item ->
                    val bundle = Bundle().apply {
                        putInt("id", item.id)
                        putString("title", item.title)
                        putString("description", item.description)
                    }
                    findNavController().navigate(R.id.action_MyListFragment_to_updateFragment, bundle)
                },
            )
        })
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_MyListFragment_to_addFragment)
        }
    }
}