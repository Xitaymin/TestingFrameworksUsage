package practise

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class HelperKtTest {

    /*
    * Як правило, варто об'єднувати позитивні та негативні тестові сценарії в одному методі тільки тоді,
    * коли за вхідними параметрами можна легко визначити, який сценарій чому відповідає.
    * В іншому разі негативні та позитивні тестові сценарії слід розділити.
    * А якщо поведінка стає занадто складною, взагалі не використовуйте параметризовані тести.
    * У такому разі кожен негативний і позитивний тестовий сценарій краще описати окремим тестом.
    */

    /*
     * todo написати параметризовані тести для функцій з класу Helper.kt, при реалізації використати наступні аннотації:
     * - @CsvSource
     * - @CsvFileSource
     * - @MethodSource (для передачі параметра у функцію створіть і передавайте data class, замість стандартного класу Arguments)
     * - @ValueSource
     * - NullAndEmptySource
     */

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
        isValidPassword(password) shouldBe expected
    }

    //todo yb додати приклади з CSVFileSource, MethodSource, EnumSource



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
