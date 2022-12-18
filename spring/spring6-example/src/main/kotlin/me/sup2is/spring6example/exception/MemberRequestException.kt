package me.sup2is.spring6example.exception

class MemberRequestException(errorBody: String) : Throwable(errorBody)
