class GetWeatherByCityUseCase(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(city: String) =
        repository.getWeatherByCity(city)
}