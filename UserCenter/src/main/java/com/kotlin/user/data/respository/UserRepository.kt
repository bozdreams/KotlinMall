package com.kotlin.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResq
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocal.RegisterReq
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){

    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResq<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }
}