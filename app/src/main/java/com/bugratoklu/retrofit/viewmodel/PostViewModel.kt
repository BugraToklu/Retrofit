package com.bugratoklu.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugratoklu.retrofit.Model.Post
import com.bugratoklu.retrofit.data.Service
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PostViewModel:ViewModel() {
    val posts = MutableLiveData<List<Post>>()
    private val service : Service = Service()
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun refreshData(){
        fetchDataRemoteApi()
    }
    fun fetchDataRemoteApi(){
        disposable.add(
            service.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Post>>(){
                    override fun onSuccess(postList: List<Post>) {
                        posts.value = postList
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}