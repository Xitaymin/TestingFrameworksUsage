package lifecycle

import org.junit.jupiter.api.*

class SomeTest {

    init {
        println("[SomeTest] Ініціалізація класу SomeTest")
    }

    @BeforeEach
    fun beforeEachSomeTest() {
        println("[SomeTest] Виконується BeforeEach")
    }

    @AfterEach
    fun afterEachSomeTest() {
        println("[SomeTest] Виконується AfterEach")
    }

    @Test
    fun someTest1() {
        println("[SomeTest] Виконується someTest1")
    }

    @Test
    fun someTest2() {
        println("[SomeTest] Виконується someTest2")
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setupSomeTest() {
            println("[SomeTest] Виконується BeforeAll")
        }

        @JvmStatic
        @AfterAll
        fun teardownSomeTest() {
            println("[SomeTest] Виконується AfterAll")
        }
    }
}