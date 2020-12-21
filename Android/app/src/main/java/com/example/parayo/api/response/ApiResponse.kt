package com.example.parayo.api.response

// 서버 응답구조에 맞는 구조를 만들어 준다.
data class ApiResponse<T>(
        val success: Boolean,
        val data: T? = null,
        val message: String? = null
){

    companion object {

        // 자체적으로 오류를 만들어 낼 수 있기 때문에 error 함수 추가
        // reified 는 인라인 함수에 붙을 수 있는  특별한 키워드로 같은 형태의 호출을 위해 사용
        //https://medium.com/harrythegreat/kotlin-inline-noinline-%ED%95%9C%EB%B2%88%EC%97%90-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-1d54ff34151c
        inline fun <reified T> error(message: String?= null) = ApiResponse(false, null as T?, message)
    }

}