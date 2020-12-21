package com.example.parayo.common

/*
* 전역 익셉션 핸들러에 대한
* 내용이다.
* https://jeong-pro.tistory.com/195
* 참고하면 내용을 알 수 있음.
* */


import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

//@ExceptionHandler가 하나의 클래스에 대한 것이라면, @ControllerAdvice는
// 모든 @Controller 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation이다.
//
@ControllerAdvice
@RestController
class ParayoExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java) // ::은 참조를 의미

    @ExceptionHandler(ParayoException::class)
    fun handleParayoException(e: ParayoException): ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error("알수없는 오류가 발생했습니다.")
    }
}