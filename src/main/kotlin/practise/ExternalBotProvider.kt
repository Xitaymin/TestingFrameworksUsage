package practise

data class Bot(val name: String, val email: String, val age: Int, val aggressionPercentage: Int, val iq: Int)

//Імітація мережевого сервісу, який генерує ботів, кожен запит має повертати нового бота з властивостями у певних межах
class ExternalBotProvider {

    fun soloviiovHaterBot() = Bot(
        name = "Іван",
        email = "onufriy1966@google.com",
        age = 19,
        aggressionPercentage = 40,
        iq = 110
    )
}


