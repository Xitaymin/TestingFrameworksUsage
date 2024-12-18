package practise

data class Bot(val name: String, val email: String, val age: Int, val aggressionPercentage: Int, val iq: Int)

//Імітація мережевого сервісу, який генерує ботів, кожен запит має повертати нового бота
class ExternalBotProvider {

    fun soloviiovHaterBot() = Bot(
        name = "Онуфрий",
        email = "onufriy1966@yandex.ru",
        age = 54,
        aggressionPercentage = 95,
        iq = 80
    )
}


