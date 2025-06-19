package com.example.infrastructure.database

import org.jetbrains.exposed.sql.Database

fun connectDatabase() {
    val dbUser = getEnv("DB_USER")
    val dbPass = getEnv("DB_PASS")
    val dbHost = getEnv("DB_HOST")
    val dbPort = getEnv("DB_PORT")
    val dbName = getEnv("DB_NAME")

    println("---")
    println("System.getenv: " + System.getenv("DB_USER") + ", dbUser: " + dbUser)
    println("System.getenv: " + System.getenv("DB_PASS") + ", dbPass: " + dbPass)
    println("System.getenv: " + System.getenv("DB_HOST") + ", dbHost: " + dbHost)
    println("System.getenv: " + System.getenv("DB_PORT") + ", dbPort: " + dbPort)
    println("System.getenv: " + System.getenv("DB_NAME") + ", dbName: " + dbName)
    println("---")

    val jdbcUrl = "jdbc:mysql://$dbHost:$dbPort/$dbName?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"

    Database.connect(
        url = jdbcUrl,
        driver = "com.mysql.cj.jdbc.Driver",
        user = dbUser,
        password = dbPass
    )
}

fun getEnv(key: String): String {
    return System.getProperty(key)
        ?: System.getenv(key)
        ?: error("$key is not set")
}
