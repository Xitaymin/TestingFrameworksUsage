package practise

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
     * - @MethodSource (для передачі параметра у функцію створіть і передавайте data class, замість стандартного класу Arguments)
     * - @ValueSource
     * - @NullAndEmptySource
     */

    @ValueSource(strings = ["passwrD0*", "PASSW0Rd%", "l234567&9O"])
    @ParameterizedTest
    fun `valid password accepted`(validPassword: String) {
        isValidPassword(validPassword) shouldBe true
    }

    @NullAndEmptySource
    @ValueSource(strings = ["password", "12345678", "aD#", "iїпШщч0!"])
    @ParameterizedTest
    fun `invalid password is rejected`(invalidPasswod: String?) {
        isValidPassword(invalidPasswod) shouldBe false
    }

    private fun provideValidAnagrams(): Stream<AnagramPair> {
        return Stream.of(
            AnagramPair("listen", "silent"),
            AnagramPair("Triangle", "Integral"),
            AnagramPair("a b c", "c b a"),
            AnagramPair("word", "word"),
            AnagramPair("123!@#","321#@!")

        )
    }

    @MethodSource("provideValidAnagrams")
    @ParameterizedTest
    fun `valid anagrams are accepted`(anagramPair: AnagramPair) {
        areAnagrams(anagramPair.initial, anagramPair.candidate) shouldBe true
    }

    private fun provideInvalidAnagrams(): Stream<AnagramPair> {
        return Stream.of(
            AnagramPair("Triangle", "Integrol"),
            AnagramPair("a b c", "c b a "),
        )
    }
    @MethodSource("provideInvalidAnagrams")
    @ParameterizedTest
    fun `invalid anagrams are rejected`(anagramPair: AnagramPair) {
        areAnagrams(anagramPair.initial, anagramPair.candidate) shouldBe false
    }

    @CsvSource("madam, true", "racecar, true", "level, true", "А роза упала на лапу Азора, true", "hello, false")
    @ParameterizedTest
    fun `palindrome correctly defined`(input: String, expected: Boolean) {
        isPalindrome(input) shouldBe expected
    }
}

data class AnagramPair(val initial: String, val candidate: String)
