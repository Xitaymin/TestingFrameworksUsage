package testdoubles
class ExternalService {
	fun fetchDataFromApi() = "Real API Response"

	fun processData() = "Processed: ${fetchDataFromApi()}"
}
