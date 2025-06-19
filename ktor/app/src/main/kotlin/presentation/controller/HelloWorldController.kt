package com.example.presentation.controller

import com.example.application.usecase.HelloWorldUseCase

class HelloWorldController(private val helloWorldUseCase: HelloWorldUseCase) {
    fun helloWorld(): String {
        return helloWorldUseCase.execute()
    }
}
