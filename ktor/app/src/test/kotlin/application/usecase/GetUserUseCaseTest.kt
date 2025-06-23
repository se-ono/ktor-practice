
import com.example.application.usecase.GetUserUseCase
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetUserUseCaseTest {

    @Test
    fun `should return user when found`() {
        val userId = 1L
        val userName = "Test User 1"
        val mockRepo = mock<UserRepository>()
        val expectedUser = User(id = userId, name = userName)

        // mockRepo.findById(1L) を呼び出したら expectedUser を返すように設定する
        whenever(mockRepo.findById(userId)).thenReturn(expectedUser)

        val useCase = GetUserUseCase(mockRepo)
        val actualUser = useCase.execute(userId)

        assertEquals(expectedUser, actualUser)
        verify(mockRepo, times(1)).findById(userId)
    }

    @Test
    fun `should return null when not found`() {
        val userId = 2L
        val userName = "Test User 2"

        val mockRepo = mock<UserRepository>()

        // mockRepo.findById(2L) を呼び出したら null を返すように設定する
        whenever(mockRepo.findById(userId)).thenReturn(null)

        val useCase = GetUserUseCase(mockRepo)
        val result = useCase.execute(userId)

        assertNull(result)
        verify(mockRepo, times(1)).findById(userId)
    }
}
