package com.devkraken.mytest.features.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devkraken.mytest.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var addViewModel: AddViewModel
    private lateinit var binding: FragmentAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.activity?.let { activity ->
            addViewModel = AddViewModel(activity.application)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitButton.setOnClickListener {
            addViewModel.addItem(
                binding.formTitle.text.toString(),
                binding.formDescription.text.toString()
            )
            findNavController().popBackStack()
        }
    }
}