package com.guvyerhopkins.tsusocial.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.guvyerhopkins.tsusocial.R
import com.guvyerhopkins.tsusocial.core.JsonFileParser

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    private lateinit var adapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProvider(
                this,
                SearchViewModelFactory(JsonFileParser(requireActivity().applicationContext))
            ).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        searchViewModel.mockUsers.observe(viewLifecycleOwner, Observer {
            val mockUsers = it ?: return@Observer
            adapter.setItems(mockUsers)
        })

        adapter = SearchAdapter()

        return root
    }
}