package com.geek.app.ui.encyclopedia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geekgenius.R
import com.example.geekgenius.databinding.FragmentEncyclopediaBinding
import com.geek.app.model.Article
import com.geek.app.ui.adapter.ArticleAdapter
import com.geek.app.ui.detail_article.DetailArticleActivity

class EncyclopediaFragment : Fragment() {

    private var _binding: FragmentEncyclopediaBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<EncyclopediaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentEncyclopediaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.contentHeaderSearch?.tvTitle?.text = getString(R.string.ensiklopedia)
        val articleAdapter = ArticleAdapter(
            onClick = ::navigateToDetail
        )

        binding?.rvEncyclopedia?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
        viewModel.encyclopedias.observe(viewLifecycleOwner, articleAdapter::submitList)

        binding?.contentHeaderSearch?.searchBar?.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrEmpty()) {
                        viewModel.resetSearch()
                    } else {
                        viewModel.searchEncyclopedias(newText)
                    }
                    return true
                }
            })
        }
    }

    private fun navigateToDetail(article: Article) {
        val intent = Intent(requireActivity(), DetailArticleActivity::class.java).apply {
            putExtra(DetailArticleActivity.EXTRA_ARTICLE, article)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
