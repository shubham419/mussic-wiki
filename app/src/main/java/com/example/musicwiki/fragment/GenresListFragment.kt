package com.example.musicwiki.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapter.MainRecyclerViewAdapter
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.api.RetrofitHelper
import com.example.musicwiki.databinding.FragmentGenresListBinding
import com.example.musicwiki.models.genres.Tag
import com.example.musicwiki.repository.GenresRepository
import com.example.musicwiki.viewmodels.GenresListFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel

class GenresListFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var binding: FragmentGenresListBinding
    private lateinit var adapter: MainRecyclerViewAdapter
    val list: MutableList<Tag> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenresListBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this)[GenresListFragmentViewModel::class.java]

        adapter = MainRecyclerViewAdapter(sharedViewModel)

        viewModel.genres.observe(viewLifecycleOwner) {
            if (it != null) {
                list.addAll(it.toptags.tag)
                adapter.setContentList(list.subList(0, 10))
            }
        }

        sharedViewModel.transition.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_genresListFragment_to_genresDetailFragment)
            }
        })

        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = this.adapter

        binding.showMore.setOnClickListener() {
            adapter.setContentList(list)
            it.visibility = View.GONE
        }

        return binding.root
    }

}