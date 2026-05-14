@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {

    val state = viewModel.state

    var city by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = city,
            onValueChange = {
                city = it
            },
            label = {
                Text("Enter US City")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                viewModel.searchCity(city)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search Weather")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.error?.let {

            Text(
                text = it,
                color = Color.Red
            )
        }

        state.weather?.let { weather ->

            val icon =
                "https://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png"

            Text(
                text = weather.name,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            AsyncImage(
                model = icon,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "Temperature: ${weather.main.temp}°F"
            )

            Text(
                text = "Feels Like: ${weather.main.feels_like}°F"
            )

            Text(
                text = "Humidity: ${weather.main.humidity}%"
            )

            Text(
                text = "Wind Speed: ${weather.wind.speed}"
            )

            Text(
                text = weather.weather[0].description
            )
        }
    }
}