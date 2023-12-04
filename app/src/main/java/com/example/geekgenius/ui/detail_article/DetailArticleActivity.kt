package com.geek.app.ui.detail_article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.geekgenius.R
import com.example.geekgenius.databinding.ActivityDetailArticleBinding
import com.geek.app.model.Article

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = intent.getParcelableExtra<Article>(EXTRA_ARTICLE)

        binding.apply {
            btnBack.setOnClickListener { finish() }
            ivArticle.setImageResource(article?.image ?: R.drawable.article_1)
            tvTitle.text = article?.title

            val htmlText = HtmlCompat.fromHtml(article?.description.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
            tvContent.text = htmlText
        }
    }

    companion object {
        const val EXTRA_ARTICLE = "extra_article"
    }
}