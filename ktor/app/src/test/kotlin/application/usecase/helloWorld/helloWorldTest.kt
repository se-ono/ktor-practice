package application.usecase.helloWorld

import com.example.application.usecase.helloWorld.HelloWorldUseCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class helloWorldTest {

    @Test
    fun `should return user when found`() {
        val expectedText = "Hello World!"

        val useCase = HelloWorldUseCase()
        val actualText = useCase.execute()

        Assertions.assertEquals(expectedText, actualText)
    }
}