package com.example.quizapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuestionBinding
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    private val viewModel: AppViewModel by activityViewModels()

    lateinit var binding:FragmentQuestionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question, container, false)

        binding.viewModel = viewModel
      viewModel.notifyStart()
        viewModel.data.observe(requireActivity(), Observer {
            Log.i("TAG1234", "onCreateView: ${it.correctAnswer}")

               binding.question = it
               binding.progress = viewModel.indx+1
            }
        )

    binding.button2.setOnClickListener {

        var checkedRadio: Int = binding.radioGroup.checkedRadioButtonId

        val radioButton = binding.root.findViewById<RadioButton>(checkedRadio)

        viewModel.submit(radioButton.text.toString(),binding.question!!)

        if (viewModel.completeTheQuiz){
            findNavController().navigate(R.id.action_questionFragment_to_resultFragment)
        }


    }
        return binding.root
    }


}