package com.example.interviewprepbatch.passData_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interviewprepbatch.R
import com.example.interviewprepbatch.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    lateinit var binding : FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        // Bundle bundle = getArguments()

        if(bundle!=null){

            val data = bundle.getString("string")

            binding.tvData.text = data

        }

    }
}