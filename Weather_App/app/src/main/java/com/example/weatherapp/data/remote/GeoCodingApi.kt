interface GeoCodingApi {

    @GET("geo/1.0/direct")
    suspend fun getCoordinates(
        @Query("q") city: String,
        @Query("limit") limit: Int = 1,
        @Query("appid") apiKey: String
    ): List<GeoLocationResponse>
}