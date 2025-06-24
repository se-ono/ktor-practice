package application.usecase.user

import com.example.application.request.user.UpdateUserRequest
import com.example.application.usecase.user.UpdateUserUseCase
import com.example.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class UpdateUserUseCaseTest {
    @Test
    fun `should update user with correct id and name`() {
        val userId = 1L
        val userName = "Test Update User 1"

        val mockRepo = mock<UserRepository>()
        val useCase = UpdateUserUseCase(mockRepo)
        val request = UpdateUserRequest(id = userId, name = userName)

        useCase.execute(request)

        verify(mockRepo, times(1)).update(userId, userName)
    }
}