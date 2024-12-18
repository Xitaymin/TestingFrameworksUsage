import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationUtilsKtTest {

    //todo yb 5 - navigation only
    @Test
    fun `age validation rejects negative value`() {
        assertThrows<ValidationException> {
            validateAge(-1)
        }
    }
}

