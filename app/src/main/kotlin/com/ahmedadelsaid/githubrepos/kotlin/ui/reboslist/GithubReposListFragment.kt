package com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.ahmedadelsaid.githubrepos.R
import com.ahmedadelsaid.githubrepos.kotlin.Injection
import com.ahmedadelsaid.githubrepos.kotlin.Injection.USER_ID
import com.ahmedadelsaid.githubrepos.kotlin.data.NetworkState
import com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist.adapter.UserAdapter
import com.ahmedadelsaid.githubrepos.kotlin.ui.repodetails.RepoDetailsActivity
import kotlinx.android.synthetic.main.fragment_github_repos_list.*
import timber.log.Timber

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * A placeholder fragment containing a simple view.
 */

class GithubReposListFragment : Fragment() {

    private lateinit var viewModel: GithubReposListViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github_repos_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this@GithubReposListFragment.context?.let { context ->

            viewModel = ViewModelProviders.of(
                this@GithubReposListFragment,
                Injection.provideViewModelFactory(context)
            ).get(GithubReposListViewModel::class.java)

            initAdapter()
            initSwipeToRefresh()
            initSearch(savedInstanceState?.getString(LAST_SEARCH_QUERY) ?: DEFAULT_QUERY)

            updateRepoListFromInput()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAST_SEARCH_QUERY, viewModel.lastQueryValue())
    }

    private fun initAdapter() {
        activity?.let {
            adapter = UserAdapter({ userId ->
                startRepoDetailsActivity(userId)
            }, { viewModel.retry() })
            list.adapter = adapter

            viewModel.users.observe(this, Observer { users ->
                Timber.d("list: ${users?.size}")
                showEmptyList(users?.size == 0)
                adapter.submitList(users)
            })
        }
    }

    private fun initSwipeToRefresh() {
        viewModel.networkState.observe(this, Observer { networkState ->
            adapter.setNetworkState(networkState)
            adapter.currentList?.let {
                networkState?.let { state ->
                    if (state.message?.isNotBlank() == true)
                        Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
                    users_swipe_refresh_layout.isRefreshing = networkState.status ==
                            NetworkState.LOADING.status
                }
            }
        })
        users_swipe_refresh_layout.setOnRefreshListener({ viewModel.refresh() })
    }

    private fun initSearch(query: String) {
        search_name.setText(query)
        search_name.setOnEditorActionListener({ _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                updateRepoListFromInput()
                true
            } else {
                false
            }
        })
        search_name.setOnKeyListener({ _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                updateRepoListFromInput()
                true
            } else {
                false
            }
        })
    }

    private fun updateRepoListFromInput() {
        search_name.text.trim().let { query ->
            if (query.isNotEmpty()) {
                list.scrollToPosition(0)
                viewModel.searchUser(query.toString())
                adapter.submitList(null)
            }
        }
    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            empty_list.visibility = View.VISIBLE
            list.visibility = View.GONE
        } else {
            empty_list.visibility = View.GONE
            list.visibility = View.VISIBLE
        }
    }

    private fun startRepoDetailsActivity(userId: Long) {
        activity.let {
            val intent = Intent(it, RepoDetailsActivity::class.java)
            intent.putExtra(USER_ID, userId)
            startActivity(intent)
        }
    }

    companion object {
        private const val LAST_SEARCH_QUERY = "last_search_query"
        private const val DEFAULT_QUERY = "ahmed"
    }
}
