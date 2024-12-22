# Практики ефективного тестування

## Використання адаптерів
- Ви завжди повинні писати власні адаптери на базі сторонніх бібліотек і мокати ці адаптери замість нижчих типів.

## Простота взаємодії з залежностями
- Ваш код повинен або взаємодіяти з позапроцесними залежностями, або бути складним - але не робити і те й інше одночасно.

### Приклад використання шаблона Humble Object

#### До застосування шаблона Humble Object
До застосування шаблона код може бути важким для тестування через щільну інтеграцію бізнес-логіки та взаємодії із зовнішніми залежностями:

```kotlin
import java.util.*

class ReportGenerator {
  fun generateReport(data: List<String>, outputType: String) {
    if (outputType == "console") {
      data.filter { it.contains("ERROR") }
        .map { it.uppercase(Locale.getDefault()) }
        .forEach { println(it) }
    } else if (outputType == "file") {
      val file = File("report.txt")
      file.writeText(data.filter { it.contains("ERROR") }
        .joinToString("") { it.uppercase(Locale.getDefault()) })
    } else {
      throw IllegalArgumentException("Unsupported output type: $outputType")
    }
  }
}
```
У цьому прикладі генератор звіту обробляє як бізнес-логіку (фільтрування даних), так і взаємодію із зовнішнім середовищем (консоль або файл). Це ускладнює тестування.

#### Після застосування шаблона Humble Object
Шаблон Humble Object розділяє взаємодію із зовнішніми залежностями та бізнес-логіку:

```kotlin
class ReportGenerator(private val outputHandler: OutputHandler) {
    fun generateReport(data: List<String>) {
        val filteredData = data.filter { it.contains("ERROR") }
            .map { it.toUpperCase() }
        filteredData.forEach { outputHandler.handleOutput(it) }
    }
}

interface OutputHandler {
    fun handleOutput(message: String)
}

class ConsoleOutputHandler : OutputHandler {
    override fun handleOutput(message: String) {
        println(message)
    }
}

class FileOutputHandler(private val fileName: String) : OutputHandler {
    private val file = File(fileName)

    override fun handleOutput(message: String) {
        file.appendText(message + "\n")
    }
}
```
Тепер логіка фільтрування та форматування даних повністю ізольована в `ReportGenerator`, а `OutputHandler` відповідає лише за вивід однієї строки за раз. Це значно полегшує тестування, оскільки `OutputHandler` можна замінити на моки в тестах для `ReportGenerator`.

![Humble Object Diagram](sandbox:/mnt/data/Знімок%20екрана%202024-12-22%20220915.png)

## Принципи використання моків
- Під час використання моків завжди керуйтеся таким принципом: перевіряйте взаємодії з некерованими залежностями на самих кордонах вашої системи.

## Впровадження залежностей
- Завжди явно впроваджуйте всі залежності (включно з логерами) - або через конструктор, або через аргументи методу.

## Управління циклічними залежностями
- Циклічні залежності збільшують когнітивне навантаження при спробах розібратися в коді. Типовий приклад - зворотний виклик (коли сторона, що викликається, повідомляє ту, що викликає, про результат своєї роботи).
  - Розірвіть цикл введенням об'єкта-значення.
  - Використовуйте цей об'єкт-значення для повернення результату від сторони, що викликається, до сторони, що викликає.
