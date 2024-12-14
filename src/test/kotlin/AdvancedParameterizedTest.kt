import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.util.*

class AdvancedParameterizedTests
/*
* Як правило, варто об'єднувати позитивні та негативні тестові сценарії в одному методі тільки тоді,
* коли за вхідними параметрами можна легко визначити, який сценарій чому відповідає.
* В іншому разі негативні та позитивні тестові сценарії слід розділити.
* А якщо поведінка стає занадто складною, взагалі не використовуйте параметризовані тести.
* У такому разі кожен негативний і позитивний тестовий сценарій краще описати окремим тестом.
*/
{
	fun isValidPassword(password: String): Boolean
	{
		val lengthRequirement = password.length >= 8
		val hasUppercase = password.any { it.isUpperCase() }
		val hasLowercase = password.any { it.isLowerCase() }
		val hasDigit = password.any { it.isDigit() }
		val hasSpecialChar = password.any { "!@#$%^&*()_+".contains(it) }
		return lengthRequirement && hasUppercase && hasLowercase && hasDigit && hasSpecialChar
	}

	@ParameterizedTest
	@CsvSource(
		"P@ssw0rd,true",
		"password,false",
		"Passw0rd,false",
		"P@ssword,false",
		"Short1!,false",
		"Valid123!,true"
	          )
	fun `test isValidPassword with CsvSource`(password: String, expected: Boolean)
	{
		assert(isValidPassword(password) == expected)
	}


	//todo yb додати приклади з CSVFileSource, MethodSource, EnumSource, ArgumentSource


	fun isValidIpAddress(ip: String): Boolean
	{
		val regex = Regex("^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})$")
		return regex.matches(ip)
	}

	@ParameterizedTest
	@ValueSource(
		strings = [
			"192.168.1.1",
			"255.255.255.255",
			"0.0.0.0",
			"127.0.0.1"
		]
	            )
	fun `test isValidIpAddress with ValueSource (valid IPs)`(ip: String)
	{
		assert(isValidIpAddress(ip))
	}

	@ParameterizedTest
	@EmptySource
	@ValueSource(
		strings = [
			"256.256.256.256",
			"123.456.789.0",
			"192.168.1",
			"192.168.1.1.1",
			"abc.def.ghi.jkl"
		]
	            )
	fun `test isValidIpAddress with ValueSource (invalid IPs)`(ip: String)
	{
		assert(!isValidIpAddress(ip))
	}

	fun areAnagrams(original: String, candidate: String): Boolean
	{
		return original.lowercase(Locale.getDefault()).toCharArray()
			.sorted() == candidate.lowercase(Locale.getDefault())
			.toCharArray().sorted()
	}

	@ParameterizedTest
	@CsvSource(
		// Позитивні випадки
		"listen,silent,true",
		"Triangle,Integral,true",
		"aabb,bbaa,true",
		"'','',true",
		// Негативні випадки
		"apple,app,false",
		"hello,world,false",
		"Test,Sett1,false",
		// Граничні умови
		"'',word,false",
		"a b c,c b a,true",
		"123!@#,321#@!,true",
		"abcd,abdc,true",
		// Проблеми із чутливістю до регістру
		"UpperCase,uppercase,true"
	          )
	fun `test areAnagrams`(initial: String, candidate: String, expected: Boolean)
	{
		assert(areAnagrams(initial, candidate) == expected)
	}

}
