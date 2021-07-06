package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Fragment1Binding

class Fragment1:Fragment() {
    lateinit var binder : Fragment1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = Fragment1Binding.inflate(layoutInflater)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binder.fInFragment1.setOnClickListener(View.OnClickListener {
            var fragmentManager = activity?.supportFragmentManager
            var fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainerView,Fragment2())
            fragmentTransaction?.commit()
        })
    }
}