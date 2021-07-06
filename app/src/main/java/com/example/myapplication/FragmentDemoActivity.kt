package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityFragmentDemoBinding

class FragmentDemoActivity : AppCompatActivity() {

    lateinit var binding :ActivityFragmentDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityFragmentDemoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFragment(Fragment1())

        binding.fFragmentBtn1.setOnClickListener(View.OnClickListener {
            replaceFragment(Fragment1())
        })

        binding.fFragmentBtn2.setOnClickListener(View.OnClickListener {
            replaceFragment(Fragment2())
        })
    }

    private fun replaceFragment(a: Fragment)
    {
        var fragmentManager = supportFragmentManager
        var fragmentTrasation = fragmentManager.beginTransaction()
        fragmentTrasation.replace(R.id.fragmentContainerView,a)
        fragmentTrasation.commit()
    }
}