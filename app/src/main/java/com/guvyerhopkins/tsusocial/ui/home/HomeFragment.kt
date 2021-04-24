package com.guvyerhopkins.tsusocial.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.guvyerhopkins.tsusocial.R
import com.guvyerhopkins.tsusocial.core.AppDatabase
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(
                this, HomeViewModelFactory(
                    AppDatabase.getInstance(requireContext()).loggedInUserDao()
                )
            ).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        textView = root.findViewById(R.id.text_home)

        return root
    }

    override fun onResume() {
        super.onResume()
        textView.text =
            getString(
                homeViewModel.getGreeting(Calendar.getInstance()).first,
                homeViewModel.getGreeting(Calendar.getInstance()).second
            )
    }
}

