package com.example.infrastructure.env

import java.io.File

class EnvLoader {
    fun loadEnv(path: String): Map<String, String> {
        val env = mutableMapOf<String, String>()
        val file = File(path)
        if (file.exists()) {
            file.readLines()
                .filter { it.isNotBlank() && !it.startsWith("#") }
                .forEach { line ->
                    val (key, value) = line.split("=", limit = 2)
                    env[key.trim()] = value.trim()
                }
        }
        return env
    }
}
