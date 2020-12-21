package com.example.parayo.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository // 인터페이스가 레파지토리 빈으로서 동작한다는 것을 나타냄
// 레파지토리는 의미적으로 이 클래스가 데이터의 읽기 쓰기를 담당한다는 것을 나타냄
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email:String): User? // 이메일로 검색했을때는 한명 혹은 0명의 유져만 검색이 되어야 하기 때문에 반환이 안될 수 있음을 가정




}