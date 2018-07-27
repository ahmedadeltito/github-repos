package com.ahmedadelsaid.githubrepos.kotlin.reboslist

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedadelsaid.githubrepos.R

/**
 * A placeholder fragment containing a simple view.
 */
class GithubReposListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github_repos_list, container, false)
    }
}
