# Weather App

A simple Android weather application built with Jetpack Compose, Hilt dependency injection, Retrofit, and the OpenWeather APIs.

## Overview

This app allows users to search for weather information by entering a US city name. It uses the OpenWeather geocoding API to resolve city coordinates and then retrieves current weather data for that location.

## Features

- Search weather by city name
- Display current temperature, feels-like temperature, humidity, wind speed, and weather description
- Show weather icon from OpenWeather
- Uses Jetpack Compose for UI
- Hilt for dependency injection
- Retrofit + Gson for network requests
- Coil for image loading
- Location service support included for future location-based weather lookup

## Architecture

The app is organized using a clean-ish separation between layers:

- `data/` - Remote API interfaces and repository implementation
- `domain/` - Repository contract and use case entry points
- `presentation/` - Compose UI and ViewModel state management
- `location/` - Location helper service
- `di/` - Hilt dependency injection module
- `utils/` - Shared constants

## Key Technologies

- Kotlin
- Android Jetpack Compose
- Hilt
- Retrofit
- Gson
- Coil
- Google Play Services Location
- Coroutines

## Project Location

The Android project root is inside the nested folder:

- `Weather_App/Weather_App`

Open that folder in Android Studio to build and run the app.

## Prerequisites

- Android Studio
- Android SDK (compileSdk 34)
- Gradle
- OpenWeather API key

## Setup

1. Obtain an OpenWeather API key from https://openweathermap.org/api.
2. Create a `gradle.properties` file in the project root next to `build.gradle` inside `Weather_App/Weather_App/` if it does not already exist.
3. Add the following line:

```properties
OPEN_WEATHER_API_KEY=your_api_key_here
```

> The app reads the API key through `BuildConfig.OPEN_WEATHER_API_KEY` via Gradle properties.

## Build and Run

From Android Studio:

1. Open `Weather_App/Weather_App` as the project.
2. Sync Gradle.
3. Run the app on an emulator or physical device.

From the command line:

```bash
cd Weather_App/Weather_App
./gradlew assembleDebug
```

If you want to pass the API key directly on the command line:

```bash
./gradlew assembleDebug -POPEN_WEATHER_API_KEY=your_api_key_here
```

## Important Files

- `app/src/main/java/com/example/weatherapp/MainActivity.kt` — App entry point
- `app/src/main/java/com/example/weatherapp/presentation/screen/WeatherScreen.kt` — Main Compose screen
- `app/src/main/java/com/example/weatherapp/presentation/viewmodel/WeatherViewModel.kt` — UI state and weather search logic
- `app/src/main/java/com/example/weatherapp/data/repository/WeatherRepositoryImpl.kt` — Weather data retrieval logic
- `app/src/main/java/com/example/weatherapp/data/remote/WeatherApi.kt` — OpenWeather current weather API
- `app/src/main/java/com/example/weatherapp/data/remote/GeoCodingApi.kt` — OpenWeather geocoding API
- `app/src/main/java/com/example/weatherapp/di/AppModule.kt` — Hilt dependency providers
- `app/src/main/java/com/example/weatherapp/location/LocationService.kt` — Location helper service

## Notes

- The app currently focuses on city-name search.
- Location support is included in `LocationService.kt` and can be extended to automatically fetch weather for the device location.
- The manifest includes required permissions for Internet and location access.

## License

No license provided.
