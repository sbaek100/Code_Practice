package com.example.parayo.domain.user

import java.util.*
import javax.persistence.*

// ENtity 애노테이션을 쓰면 이 클래스가 데이터베이스 테이블에 맵핑된 정보를 가지고 있음을 의미
@Entity(name = "user")

class User(
        var email: String,
        var password: String,
        var name: String
) {
    @Id // 이 애노ㅌ이션은 해당 필드가 테이블의 Primary Key 를 알려주는 것
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincresement 같은것
    var id: Long? = null

    var createdAt: Date? = null
    var updatedAt: Date? = null

    @PrePersist // DB 에 User 정보가 저장되기 전에 자동으로 호출외어 현재 날짜로 지정되게 하는 것
    fun prePersist(){
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate // JPA 라이프 사이블 훅을 지정하는 것. 업데이트 명령을 날리기 전에 실행
    fun preUpdate(){
        updatedAt = Date()
    }

    // ㅅㅡ프링 부트를 실행하면

}