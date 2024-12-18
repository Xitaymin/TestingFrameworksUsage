package testdoubles

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ReportServiceTest {

/*Хороший підхід у тестах - не використовувати нестабільні методи,
*які можуть повертати різні результати : дані з мережі, час, дата, рандомні числа, тощо.
*/
	@Test
	fun `report contains current date`() {
		mockkStatic(LocalDate::class)
		every { LocalDate.now() } returns LocalDate.of(2024, 1, 1)
		val reportService = ReportService()

		val result = reportService.generateReport()

		result shouldBe "Report generated on 2024-01-01"
	}
}
