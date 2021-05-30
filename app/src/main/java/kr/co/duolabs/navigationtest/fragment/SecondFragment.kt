package kr.co.duolabs.navigationtest.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kr.co.duolabs.navigationtest.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        next.setOnClickListener(this)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.next -> navigateWithText("GOOOOO HOMMMMMMME")
            R.id.back -> navController.popBackStack()
        }
    }

    fun navigateWithText(str: String) {
        val bundle = bundleOf("value" to str)
        navController.navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
    }

}