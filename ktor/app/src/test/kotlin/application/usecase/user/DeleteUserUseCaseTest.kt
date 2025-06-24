package application.usecase.user

import com.example.application.request.user.DeleteUserRequest
import com.example.application.usecase.user.DeleteUserUseCase
import com.example.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class DeleteUserUseCaseTest {
    @Test
    fun `should delete user with correct id`() {
        val userId = 1L

        val mockRepo = mock<UserRepository>()
        val useCase = DeleteUserUseCase(mockRepo)
        val request = DeleteUserRequest(id = userId)

        useCase.execute(request)

        verify(mockRepo, times(1)).delete(userId)
    }
}