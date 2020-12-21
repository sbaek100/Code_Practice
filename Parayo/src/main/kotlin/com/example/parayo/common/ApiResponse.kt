package com.example.parayo.common

/*
* 통일된 API 스펙을 만들어 주기 위한 데이터 클래스
* API에 대한 성공과 실패에 대한 여부를 알려주는 것임.
* 오류 메세지를 간결하게 하는 것을 목적으로 한다.
* dependency : ParayoException.kt
* */

data class ApiResponse(

    // val과 var는 변수의 시작을 알리면서 변수가 불변(immutable type)인지 가변(mutable type)인지를 나타냅니다.
    // 고로 val 은 모두 불변인자임
    val success: Boolean,
    val data: Any? = null, //type에 ?를 붙임으로서 null이 가능한 변수임을 명시적으로 표현
    val message: String? = null
){
    companion object{ // companion object 를 사용하는 것은 항상 static 하게 메모리에 머물러 언제든지 호출가능함. 의미
        fun ok(data: Any? = null) = ApiResponse(true, data)
        fun error(message: String?= null) = ApiResponse(false, message = message)
    }
}