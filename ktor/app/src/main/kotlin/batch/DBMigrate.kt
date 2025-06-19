package com.example.batch

import com.example.application.batch.DBMigrateUseCase
import com.example.infrastructure.env.EnvLoader

fun main() {
    // .env を読み込んで環境変数に設定
    EnvLoader().loadEnv(".env").forEach { (key, value) ->
        System.setProperty(key, value)
    }

    // ./gradlew runDbMigrate
    println("🚀 DB Migration 開始")
    DBMigrateUseCase().execute()
    println("✅ DB Migration 完了")
}