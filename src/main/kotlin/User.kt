import kotlin.random.Random

data class User(val id: String, val name: String, val email: String, val age: Int)

fun getBotUser(): User
{
//	val id = Random.nextInt(1000, 9999).toString()
	val id = ""
//	val name = "BotUser${Random.nextInt(100, 999)}"
	val name = "Вадік"
	val email = "bot${Random.nextInt(1, 100)}@example.com"
	val age = Random.nextInt(0, 17)

	return User(id, name, email, age)
}
