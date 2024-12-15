package testdoubles
class ExternalService {
	fun fetchDataFromApi(): String {
		// Уявіть, що тут відбувається реальний виклик API
		return "Real API Response"
	}

	fun processData(): String {
		val data = fetchDataFromApi()
		return "Processed: $data"
	}
}
