class LocationService(
    private val context: Context
) {

    private val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(
        onResult: (Location?) -> Unit
    ) {

        fusedLocationClient.lastLocation
            .addOnSuccessListener {
                onResult(it)
            }
    }
}