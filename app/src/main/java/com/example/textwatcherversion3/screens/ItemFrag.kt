package com.example.textwatcherversion3.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.textwatcherversion3.R
import com.example.textwatcherversion3.databinding.Fragment2Binding

class ItemFrag : DialogFragment() , View.OnClickListener{



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog
        var textView = view?.findViewById<TextView>(R.id.textItemSingle)
        var str: String? =arguments?.getString("message")
        textView?.text=str
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onClick(v: View?) {
        dismiss()
    }

}