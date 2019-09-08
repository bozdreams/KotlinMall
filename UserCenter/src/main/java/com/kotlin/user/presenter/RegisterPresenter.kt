package com.kotlin.user.presenter

import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verify: String, pwd: String) {
        userService.register(mobile, verify, pwd)
            .excute(object : BaseSubscriber<Boolean>() {
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            }
            )
    }
}