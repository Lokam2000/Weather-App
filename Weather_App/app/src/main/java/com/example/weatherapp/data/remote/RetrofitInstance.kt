object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherApi: WeatherApi =
        retrofit.create(WeatherApi::class.java)

    val geoCodingApi: GeoCodingApi =
        retrofit.create(GeoCodingApi::class.java)
}