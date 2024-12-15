package testdoubles

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class ReportServiceTest {

	@Test
	fun `should generate report with mocked current date`() {
		// Мокаємо статичний метод LocalDate.now()
		mockkStatic(LocalDate::class)

//		Хороший підхід у тестах - не використовувати нестабільні методи, які можуть повертати різні результати : дані з мережі, час, дата, рандомні числа, тощо.
		// Налаштовуємо статичний метод, щоб завжди повертати конкретну дату
		every { LocalDate.now() } returns LocalDate.of(2024, 1, 1)

		// Викликаємо метод, який використовує LocalDate.now()
		val reportService = ReportService()
		val result = reportService.generateReport()

		// Перевіряємо результат
		assertEquals("Report generated on 2024-01-01", result)
	}
}
