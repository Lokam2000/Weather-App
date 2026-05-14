data class WeatherResponse(
    val name: String,
    val main: MainInfo,
    val weather: List<WeatherInfo>,
    val wind: WindInfo
)