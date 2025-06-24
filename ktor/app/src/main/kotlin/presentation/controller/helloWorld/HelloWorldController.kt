package com.example.presentation.controller.helloWorld

import com.example.application.usecase.helloWorld.HelloWorldUseCase

class HelloWorldController(private val helloWorldUseCase: HelloWorldUseCase) {
    fun helloWorld(): String {
        return helloWorldUseCase.execute()
    }
}