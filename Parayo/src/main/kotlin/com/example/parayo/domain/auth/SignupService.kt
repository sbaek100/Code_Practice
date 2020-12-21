package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.user.User
import com.example.parayo.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.mindrot.jbcrypt.BCrypt

@Service // 빈의 비지니스 로직을 처리하는 클래스라는 것을 표기
// aotuwire 는 빌클래스를 자동으로 주입받겠다는 것
// 자동으로 생성자, 세터, 프로퍼티 등에 autowire 붙이면 스프링이 알아서 주입해 준다는 것
class SignupService @Autowired constructor(
        private val userRepository: UserRepository  // 사용자의 데이터를 읽어와야 하기 때문에 생성자에 데이터의 읽기
        // 등을 담당하는 User Repository 를 주입받는 것임.
){
    fun signup(signupRequest: SignupRequest){
        validateRequest(signupRequest)
        checkDuplicates(signupRequest.email)
        registerUser(signupRequest)
    }

    private fun validateRequest(signupRequest: SignupRequest){
        validateEmail(signupRequest.email)
        validateName(signupRequest.name)
        validatePassword(signupRequest.password)
    }

    private fun validateEmail(email: String){
        val isNotValidEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$".toRegex(RegexOption.IGNORE_CASE)
                .matches(email).not()

        if(isNotValidEmail){
            throw ParayoException("이메일 형식이 잘못되었습니다.")
        }
    }

    private fun validateName(name: String){
        if (name.trim().length !in 2..20) throw ParayoException("이름은 2자 이상 20자 이하여야 합니다.")
    }

    private fun validatePassword(password: String){
        if (password.trim().length !in 8..20) throw ParayoException("비밀번호는 공백을 제외하고 8자이상 20자 이하여야 합니다.")
    }

    private fun checkDuplicates(email: String) = userRepository.findByEmail(email)?.let{
        throw ParayoException("이미 사용중인 이메일 입니다.")
    }


    private fun registerUser(signupRequest: SignupRequest) =
        with(signupRequest){
            val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
            val user = User(email, hashedPassword, name)
            userRepository.save(user)
        }

}