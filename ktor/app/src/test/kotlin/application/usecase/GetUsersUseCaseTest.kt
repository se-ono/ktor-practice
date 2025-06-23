package application.usecase

import com.example.application.usecase.GetUsersUseCase
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class GetUsersUseCaseTest {
    @Test
    fun `should return all users from repository`() {
        val userId1 = 1L
        val userName1 = "Test User 1"
        val userId2 = 2L
        val userName2 = "Test User 2"

        val mockRepository = mock<UserRepository>()
        val expectedUsers = listOf(
            User(id = userId1, name = userName1),
            User(id = userId2, name = userName2)
        )
        // mockRepo.getAll() を呼び出したら expectedUsers を返すように設定する
        whenever(mockRepository.getAll()).thenReturn(expectedUsers)

        val useCase = GetUsersUseCase(mockRepository)
        val actualUsers = useCase.execute()

        assertEquals(expectedUsers, actualUsers)
        verify(mockRepository, times(1)).getAll()
    }
}