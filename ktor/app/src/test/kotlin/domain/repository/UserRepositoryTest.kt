package domain.repository

import com.example.domain.repository.UserRepository
import com.example.domain.table.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    private lateinit var repository: UserRepository

    @BeforeAll
    fun setup() {
        // テスト用インメモリDB
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;", driver = "org.h2.Driver")
        transaction {
            SchemaUtils.create(UserTable)
        }
        repository = UserRepository()
    }

    @AfterEach
    fun cleanup() {
        transaction {
            UserTable.deleteAll()
        }
    }

    @Test
    fun `save should insert user`() {
        val userName1 = "Test User 1"

        val saved = repository.save(userName1)
        assertNotNull(saved.id)
        assertEquals(userName1, saved.name)
    }

    @Test
    fun `findById should return user`() {
        val userName1 = "Test User 1"

        val saved = repository.save(userName1)
        val found = repository.findById(saved.id)
        assertEquals(saved, found)
    }

    @Test
    fun `findById should return null if user does not exist`() {
        val nonExistentId = 9999L

        val found = repository.findById(nonExistentId)

        assertNull(found)
    }

    @Test
    fun `getAll should return all users`() {
        val userName1 = "Test User 1"
        val userName2 = "Test User 2"

        repository.save(userName1)
        repository.save(userName2)
        val all = repository.getAll()
        assertEquals(2, all.size)
    }

    @Test
    fun `update should modify user`() {
        val userName1 = "Test User 1"
        val updateName1 = "Test Update User 1"

        val saved = repository.save(userName1 )
        repository.update(saved.id, updateName1)
        val updated = repository.findById(saved.id)
        assertEquals(updateName1, updated?.name)
    }

    @Test
    fun `delete should remove user`() {
        val userName1 = "Test User 1"

        val saved = repository.save(userName1 )
        repository.delete(saved.id)
        val deleted = repository.findById(saved.id)
        assertNull(deleted)
    }
}
