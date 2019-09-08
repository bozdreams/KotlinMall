package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResq
import com.kotlin.user.data.protocal.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResq<String>>
}