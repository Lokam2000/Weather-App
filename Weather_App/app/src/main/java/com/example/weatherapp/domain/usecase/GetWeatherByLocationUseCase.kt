class GetWeatherByLocationUseCase(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        lat: Double,
        lon: Double
    ) = repository.getWeatherByLocation(lat, lon)
}