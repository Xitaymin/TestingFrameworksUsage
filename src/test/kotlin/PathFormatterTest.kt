import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS

class PathFormatterTest
{

	private val pathFormatter = PathFormatter()

/*
Possible conditions:
- OS
- JRE version and range
- System property
- Environment variable
- Custom condition
* */

	@Test
	@EnabledOnOs(OS.WINDOWS)
	fun `test getPlatformSpecificPath on Windows`()
	{
		val basePath = "C:\\Users\\Test"
		val fileName = "file.txt"
		val expectedPath = "C:\\Users\\Test\\file.txt"
		val result = pathFormatter.getPlatformSpecificPath(basePath, fileName)
		assertEquals(expectedPath, result, "Path should match Windows format")
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	fun `test getPlatformSpecificPath on Linux`()
	{
		val basePath = "/home/test"
		val fileName = "file.txt"
		val expectedPath = "/home/test/file.txt"
		val result = pathFormatter.getPlatformSpecificPath(basePath, fileName)
		assertEquals(expectedPath, result, "Path should match Linux format")
	}

	@Test
	@Disabled("Enable when macOS is supported")
	fun `test getPlatformSpecificPath on macOS`()
	{
		val basePath = "/Users/Test"
		val fileName = "file.txt"
		val expectedPath = "/Users/Test/file.txt"
		val result = pathFormatter.getPlatformSpecificPath(basePath, fileName)
		assertEquals(expectedPath, result, "Path should match macOS format")
	}
}
