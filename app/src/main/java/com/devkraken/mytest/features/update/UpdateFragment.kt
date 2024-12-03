package com.devkraken.mytest.features.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devkraken.mytest.Item
import com.devkraken.mytest.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    private lateinit var updateViewModel: UpdateViewModel
    private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateViewModel = UpdateViewModel(requireContext())
        val itemId = arguments?.getInt("id") ?: 0
        val itemTitle = arguments?.getString("title") ?: ""
        val itemDescription = arguments?.getString("description") ?: ""

        binding.editTitle.setText(itemTitle)
        binding.editDescription.setText(itemDescription)

        binding.saveButton.setOnClickListener {
            val updatedTitle = binding.editTitle.text.toString()
            val updatedDescription = binding.editDescription.text.toString()
            val updatedItem = Item(itemId, updatedTitle, updatedDescription)
            updateViewModel.updateItem(updatedItem)
            findNavController().popBackStack()
        }
    }
}