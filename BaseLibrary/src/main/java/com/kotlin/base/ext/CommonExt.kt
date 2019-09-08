package com.kotlin.base.ext

import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


fun <T> Observable<T>.excute(subscriber: Subscriber<T>) {
     this.observeOn(Schedulers.io())
         .subscribeOn(AndroidSchedulers.mainThread())
         .subscribe(subscriber)
}