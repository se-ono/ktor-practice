package com.example.domain.repository

import com.example.domain.model.User
import com.example.domain.table.UserTable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository{
    fun findById(id: Long): User? {
        // return User(id, "NAME XXX")
        var result: User? = null
        transaction {
            result = UserTable
                .select { UserTable.id eq id }
                .map {
                    User(
                        id = it[UserTable.id],
                        name = it[UserTable.name]
                    )
                }
                .singleOrNull()
        }
        return result
    }
}