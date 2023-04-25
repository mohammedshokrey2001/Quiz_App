package com.example.quizapp.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var binding :FragmentStartBinding
   private val viewModel : AppViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false)

        val mProgressDialog = ProgressDialog(requireContext())
        mProgressDialog.setTitle("Download Dialog")
        mProgressDialog.setMessage("Please wait until downloading Questions complete")
        mProgressDialog.show()

        viewModel.notifyDownloadComplete.observe(requireActivity(), Observer {
               if (it==true){
                   mProgressDialog.cancel()
               }
        })


        binding.button.setOnClickListener {
            viewModel.name = binding.editTextTextPersonName.text.toString()

        findNavController().navigate(R.id.action_startFragment_to_questionFragment)
        }

     return  binding.root
    }


}