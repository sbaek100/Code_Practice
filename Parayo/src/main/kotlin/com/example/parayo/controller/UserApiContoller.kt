package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SignupRequest
import com.example.parayo.domain.auth.SignupService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class UserApiContoller @Autowired constructor(
    private val signupService: SignupService
){
    @PostMapping("/users")
    fun signup(@RequestBody signupRequest: SignupRequest) = ApiResponse.ok(signupService.signup(signupRequest))
}