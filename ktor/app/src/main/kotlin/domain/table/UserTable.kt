package com.example.domain.table

import org.jetbrains.exposed.sql.Table

object UserTable : Table("users") {
    val id = long("id").autoIncrement()
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
