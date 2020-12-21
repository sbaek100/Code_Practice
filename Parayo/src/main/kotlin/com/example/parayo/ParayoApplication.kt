package com.example.parayo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


/*자신이 스프링 설정 클래스 임을 나타내고
* 동시에 스프링부트어플리케이션이 실행될 때
* 패키지 하위의 스프링컴포넌트들을 재귀적으로 탐색해 등록하는 애노테이션*/

@SpringBootApplication

open class ParayoApplication

fun main(){

    runApplication<ParayoApplication>()
}