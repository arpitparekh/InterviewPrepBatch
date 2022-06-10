package com.example.interviewprepbatch.passData_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interviewprepbatch.R
import com.example.interviewprepbatch.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    lateinit var binding : FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSend.setOnClickListener {

            val data = binding.edtData.text.toString()

            // Bundle

            val bundle = Bundle()
            bundle.putString("string",data)

            val manager = parentFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fcvHost,TwoFragment::class.java,bundle)
            transaction.addToBackStack("one")
            transaction.commit()

        }

    }
}