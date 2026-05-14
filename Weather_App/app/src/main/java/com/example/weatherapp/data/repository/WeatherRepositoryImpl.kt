class WeatherRepositoryImpl(
    private val geoCodingApi: GeoCodingApi,
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherByCity(city: String): WeatherResponse {

        val location = geoCodingApi.getCoordinates(
            city,
            1,
            BuildConfig.OPEN_WEATHER_API_KEY
        )

        if (location.isEmpty()) {
            throw Exception("City not found")
        }

        return weatherApi.getWeather(
            location[0].lat,
            location[0].lon,
            "imperial",
            BuildConfig.OPEN_WEATHER_API_KEY
        )
    }

    override suspend fun getWeatherByLocation(
        lat: Double,
        lon: Double
    ): WeatherResponse {

        return weatherApi.getWeather(
            lat,
            lon,
            "imperial",
            BuildConfig.OPEN_WEATHER_API_KEY
        )
    }
}