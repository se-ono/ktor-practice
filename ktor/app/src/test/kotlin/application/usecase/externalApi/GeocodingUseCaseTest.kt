package application.usecase.externalApi

import com.example.application.usecase.externalApi.GeocodingUseCase
import com.example.infrastructure.api.Coordinate
import com.example.infrastructure.api.GeocodingApiClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GeocodingUseCaseTest {

    @Test
    fun `should return coordinate when api returns result`() {
        runBlocking {
            val query = "渋谷駅"
            val mockApiClient = mock<GeocodingApiClient>()
            val expected = Coordinate(35.658034, 139.701636)
            whenever(mockApiClient.fetchCoordinate(query)).thenReturn(expected)

            val useCase = GeocodingUseCase(mockApiClient)
            val result = useCase.execute(query)

            assertEquals(expected, result)
            verify(mockApiClient, times(1)).fetchCoordinate(query)
        }
    }

    @Test
    fun `should return null when api returns null`() {
        runBlocking {
            val query = "Unknown Place"
            val mockApiClient = mock<GeocodingApiClient>()
            whenever(mockApiClient.fetchCoordinate(query)).thenReturn(null)

            val useCase = GeocodingUseCase(mockApiClient)
            val result = useCase.execute(query)

            assertNull(result)
            verify(mockApiClient, times(1)).fetchCoordinate(query)
        }
    }
}
