package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
//스프링에서 http 호출의 응답으로 뷰를 렌더링하지 않고 직접 텍스트로 이루어진 데이터를 출력해 주겠다는 것
class HelloApiController {
    // Get 메서드를 통해서 반환값을 응답으로 주겠다.
    @GetMapping("/api/v1/hello")
    fun hello() = ApiResponse.ok("World")
}