@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideWeatherApi(): WeatherApi {
        return RetrofitInstance.weatherApi
    }

    @Provides
    fun provideGeoCodingApi(): GeoCodingApi {
        return RetrofitInstance.geoCodingApi
    }

    @Provides
    fun provideRepository(
        geoCodingApi: GeoCodingApi,
        weatherApi: WeatherApi
    ): WeatherRepository {

        return WeatherRepositoryImpl(
            geoCodingApi,
            weatherApi
        )
    }
}