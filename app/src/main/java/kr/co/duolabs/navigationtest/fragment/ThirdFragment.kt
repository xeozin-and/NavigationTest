package kr.co.duolabs.navigationtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kr.co.duolabs.navigationtest.R
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        home.setOnClickListener(this)

        val value = arguments?.getString("value")

        value?.let {
            home.text = it
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.home -> navController.navigate(R.id.action_thirdFragment_to_mainFragment)
        }
    }
}