package com.example.domain.repository

import com.example.domain.model.User
import com.example.domain.table.UserTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository{
    fun findById(id: Long): User? {
        var result: User? = null
        transaction {
            result = UserTable
                .select { UserTable.id eq id }
                .map {
                    User(
                        id = it[UserTable.id].value,
                        name = it[UserTable.name]
                    )
                }
                .singleOrNull()
        }
        return result
    }

    fun getAll(): List<User> {
        var result: List<User> = emptyList()
        transaction {
            result = UserTable
                .selectAll()
                .map {
                    User(
                        id = it[UserTable.id].value,
                        name = it[UserTable.name]
                    )
                }
        }
        return result
    }

    fun save(userName: String): User {
        var savedUser: User? = null
        transaction {
            val insertedId = UserTable
                .insertAndGetId {
                    it[name] = userName
                }
                .value
            savedUser = User(id = insertedId, name = userName)
        }
        return savedUser!!
    }

    fun update(id: Long, userName: String) {
        transaction {
            UserTable
                .update({ UserTable.id eq id }) {
                    it[UserTable.name] = userName
                }
        }
    }

    fun delete(id: Long) {
        transaction {
            UserTable
                .deleteWhere { UserTable.id eq id }
        }
    }
}