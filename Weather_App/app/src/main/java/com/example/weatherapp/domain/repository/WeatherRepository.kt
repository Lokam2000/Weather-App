interface WeatherRepository {

    suspend fun getWeatherByCity(city: String): WeatherResponse

    suspend fun getWeatherByLocation(
        lat: Double,
        lon: Double
    ): WeatherResponse
}