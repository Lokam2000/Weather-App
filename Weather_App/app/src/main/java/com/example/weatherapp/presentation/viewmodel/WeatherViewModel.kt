@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    var state by mutableStateOf(WeatherUiState())
        private set

    fun searchCity(city: String) {

        if (city.isBlank()) {
            state = state.copy(
                error = "Please enter city"
            )
            return
        }

        viewModelScope.launch {

            try {

                state = state.copy(isLoading = true)

                val response =
                    repository.getWeatherByCity(city)

                state = state.copy(
                    isLoading = false,
                    weather = response,
                    error = null
                )

            } catch (e: Exception) {

                state = state.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    fun getWeatherByLocation(
        lat: Double,
        lon: Double
    ) {

        viewModelScope.launch {

            try {

                state = state.copy(isLoading = true)

                val response =
                    repository.getWeatherByLocation(
                        lat,
                        lon
                    )

                state = state.copy(
                    isLoading = false,
                    weather = response
                )

            } catch (e: Exception) {

                state = state.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}