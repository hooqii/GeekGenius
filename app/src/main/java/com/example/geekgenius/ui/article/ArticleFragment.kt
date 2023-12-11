package com.geek.app.ui.article

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geekgenius.databinding.FragmentArticleBinding
import com.geek.app.model.Article
import com.geek.app.ui.adapter.ArticleAdapter
import com.geek.app.ui.detail_article.DetailArticleActivity

class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<ArticleViewModel>()

    companion object {
        fun newInstance(): ArticleFragment {
            return ArticleFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleAdapter = ArticleAdapter(
            onClick = ::navigateToDetail
        )

        binding?.rvArticle?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
        viewModel.articles.observe(viewLifecycleOwner, articleAdapter::submitList)

        binding?.contentHeaderSearch?.searchBar?.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrEmpty()) {
                        viewModel.resetSearch()
                    } else {
                        viewModel.searchArticles(newText)
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
