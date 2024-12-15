import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import testdoubles.ExternalService

class ExternalServiceTest {

	@Test
	fun testProcessDataWithMockedApiResponse() {
		// Створюємо шпигуна для ExternalService
		val serviceSpy = spyk(ExternalService())

		// Перевизначаємо метод fetchDataFromApi
		every { serviceSpy.fetchDataFromApi() } returns "Mocked API Response"

		// Викликаємо метод, який використовує перевизначений fetchDataFromApi
		val result = serviceSpy.processData()

		// Перевіряємо, чи був викликаний fetchDataFromApi
		verify { serviceSpy.fetchDataFromApi() }

		// Друкуємо результат, щоб побачити змінену поведінку
		println(result) // Виведе: Processed: Mocked API Response
	}
}
