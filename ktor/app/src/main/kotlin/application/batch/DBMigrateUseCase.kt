package com.example.application.batch

import com.example.domain.table.UserTable
import com.example.infrastructure.database.connectDatabase
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DBMigrateUseCase {
    fun execute() {
        connectDatabase()
        transaction {
            // 既存テーブルを削除
            SchemaUtils.drop(UserTable)
            // テーブルを作成
            SchemaUtils.create(UserTable)
        }
    }
}

