package application.usecase

import com.example.application.request.SaveUserRequest
import com.example.application.usecase.SaveUserUseCase
import com.example.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class SaveUserUseCaseTest {

    @Test
    fun `should save user with correct name`() {
        val userName = "Test User 1"

        val mockRepository = mock<UserRepository>()
        val useCase = SaveUserUseCase(mockRepository)
        val request = SaveUserRequest(name = userName)
        useCase.execute(request)

        verify(mockRepository, times(1)).save(userName)
    }
}
