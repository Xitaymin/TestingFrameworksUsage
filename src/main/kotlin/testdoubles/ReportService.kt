package testdoubles

import java.time.LocalDate

class ReportService {
	fun generateReport(): String {
		val currentDate = LocalDate.now()
		return "Report generated on $currentDate"
	}
}
