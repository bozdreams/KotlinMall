package com.kotlin.base.data.protocol

class BaseResq<out T>(val status: Int,val  message: String, val data: T)