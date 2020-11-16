package dev.swetha.bookdetails.ui.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import coil.api.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import dagger.hilt.android.AndroidEntryPoint
import dev.swetha.bookdetails.R
import dev.swetha.bookdetails.databinding.ActivityPostDetailsBinding
import dev.swetha.bookdetails.model.Post
import dev.swetha.bookdetails.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PostDetailsActivity : BaseActivity<PostDetailsViewModel, ActivityPostDetailsBinding>() {

    override val mViewModel: PostDetailsViewModel by viewModels()

    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val postId = intent.extras?.getString(POST_ID)
            ?: throw IllegalArgumentException("`postId` must be non-null")

        initPost(postId)
    }

    private fun initPost(postId: String) {
        mViewModel.getPost(postId).observe(this, Observer { post ->
            mViewBinding.postContent.apply { this@PostDetailsActivity.post = post
                postTitle.text = post.title
                postSubTitle.text = post.subtitle
                postAuthors.text = "Authors: ".plus(post.authors)
                postPublish.text = "Published By: ".plus(post.publisher)
                postPublishDate.text = "published on: ".plus(post.publishedDate)
                postDescription.text = post.description
                postCategories.text = "Categories: ".plus(post.categories)
                postCountry.text = "Country: ".plus(post.country)
                postSaleability.text = post.saleability
                postBuylink.text = post.buyLink
            }
            mViewBinding.imageView.load(post.thumbnail) {
                crossfade(750)
                placeholder(R.drawable.ic_photo)
                error(R.drawable.ic_broken_image)
            }
        })

         }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun getViewBinding(): ActivityPostDetailsBinding =
        ActivityPostDetailsBinding.inflate(layoutInflater)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val POST_ID = "postId"
    }
}
