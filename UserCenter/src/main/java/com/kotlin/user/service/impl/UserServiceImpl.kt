package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResq
import com.kotlin.base.rx.BaseException
import com.kotlin.user.data.respository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return repository.register(mobile, verifyCode, pwd)
            .flatMap(object : Func1<BaseResq<String>, Observable<Boolean>> {
                override fun call(t: BaseResq<String>): Observable<Boolean> {
                    if (t.status != 0) {
                        return Observable.error(BaseException(t.status, t.message))
                    }
                    return Observable.just(true)
                }

            })
    }
}

