package com.runeanim.mytoyproject.ui.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.runeanim.mytoyproject.ui.RepoItemClickListener
import com.runeanim.mytoyproject.Constants
import com.runeanim.mytoyproject.R
import com.runeanim.mytoyproject.base.BaseFragment
import com.runeanim.mytoyproject.databinding.MainFragmentBinding
import com.runeanim.mytoyproject.data.Result.Success
import com.runeanim.mytoyproject.data.source.local.entity.RepositoryEntity
import com.runeanim.mytoyproject.domain.GetRepositoriesUseCase
import com.runeanim.mytoyproject.ui.RepoListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {
    private val getRepositoriesUseCase: GetRepositoriesUseCase by inject()

    private lateinit var listAdapter: RepoListAdapter

    private val getRepositoryJob = CoroutineScope(Dispatchers.Main)

    private val _items = MutableLiveData<List<RepositoryEntity>>().apply { value = emptyList() }
    val items: LiveData<List<RepositoryEntity>> = _items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.apply {
            fragment = this@MainFragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupListAdapter()
        getRepositoryJob.launch {
            val result = getRepositoriesUseCase()
            if (result is Success) {
                _items.value = result.data
            }
        }
    }

    private fun setupListAdapter() {
        listAdapter = RepoListAdapter(object :
            RepoItemClickListener {
            override fun onClickRepositoryItem(repositoryEntity: RepositoryEntity) {
                moveScreenToDetailFragment(repositoryEntity)
            }
        })
        viewDataBinding.rvRepository.adapter = listAdapter
    }

    private fun moveScreenToDetailFragment(repositoryEntity: RepositoryEntity) {
        val bundle = Bundle()
        bundle.putString(Constants.EXTRA_USER_NAME, repositoryEntity.ownerName)
        bundle.putString(Constants.EXTRA_REPOSITORY_URL, repositoryEntity.fullName)
        Navigation.findNavController(viewDataBinding.root)
            .navigate(R.id.action_main_screen_to_detail_screen, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        getRepositoryJob.cancel()
    }

    fun moveScreenToSearchFragment() {
        Navigation.findNavController(viewDataBinding.root)
            .navigate(R.id.action_main_screen_to_search_screen)
    }
}
