import java.util.*

class PathFormatter {
	fun getPlatformSpecificPath(basePath: String, fileName: String): String {
		val osName = System.getProperty("os.name").lowercase(Locale.getDefault())
		return when  {
			osName.startsWith("windows") -> "$basePath\\$fileName"
			else -> "$basePath/$fileName"
		}
	}
}
