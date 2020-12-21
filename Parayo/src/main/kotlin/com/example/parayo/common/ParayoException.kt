package com.example.parayo.common



import java.lang.RuntimeException //예외선언을 언제든지 하겠다.


/*
* Exception 을 캐치해서 상태값을 던져주는 클래스
* */
class ParayoException(message: String) : RuntimeException(message)

