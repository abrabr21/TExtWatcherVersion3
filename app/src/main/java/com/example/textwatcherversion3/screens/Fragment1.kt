package com.example.textwatcherversion3.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.textwatcherversion3.Communictor
import com.example.textwatcherversion3.UpdateTitle
import com.example.textwatcherversion3.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    lateinit var updateTitle: UpdateTitle
    private lateinit var communictor: Communictor
    private lateinit var binding: Fragment1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding.massageInput.addTextChangedListener(object :TextWatcher {
//
//            override fun afterTextChanged(s: Editable?) {
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                (activity as?  UpdateTitle)?.updateTitle(s.toString())
//
//            }
//        })
        // Inflate the layout for this fragment
        binding= Fragment1Binding.inflate(inflater)
         communictor=activity as Communictor
        binding.sendBtn.setOnClickListener {
            communictor.passData(binding.massageInput.text.toString())
            (activity as? UpdateTitle)?.updateTitle(binding.massageInput.text.toString())
            }

    return binding.root
    }



}

