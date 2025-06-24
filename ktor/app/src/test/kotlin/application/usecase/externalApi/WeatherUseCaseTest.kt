package application.usecase.externalApi

import com.example.application.usecase.externalApi.WeatherUseCase
import com.example.infrastructure.api.HourlyData
import com.example.infrastructure.api.WeatherApiClient
import com.example.infrastructure.api.WeatherResponse
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import kotlin.test.assertEquals

class WeatherUseCaseTest {

    @Test
    fun `should return weather response from API`(){
        runBlocking {
            val lat = 35.658034
            val lon = 139.701636

            val expectedResponse = WeatherResponse(
                latitude = lat,
                longitude = lon,
                generationtime_ms = 0.03170967102050781,
                hourly = HourlyData(
                    time = listOf(
                        "2025-06-24T00:00",
                        "2025-06-24T01:00",
                        "2025-06-24T02:00",
                    ),
                    temperature_2m = listOf(
                        26.0,
                        27.0,
                        27.8,
                    )
                )
            )
            val mockApiClient = mock<WeatherApiClient> {
                onBlocking { getWeatherForecast(lat, lon) } doReturn expectedResponse
            }

            val useCase = WeatherUseCase(mockApiClient)
            val result = useCase.execute(lat, lon)

            assertEquals(expectedResponse, result)
            verify(mockApiClient, times(1)).getWeatherForecast(lat, lon)
        }
    }
}
