package com.example.domain.table

import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("users") {
    val name = varchar("name", 255)
}
