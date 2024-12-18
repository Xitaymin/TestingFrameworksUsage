import org.junit.jupiter.api.*
import java.util.*

@DisplayName("A stack")
class StackTest {

	private lateinit var stack: Stack<Any>

	@Test
	@DisplayName("is instantiated with new Stack()")
	fun isInstantiatedWithNew() {
		Stack<Any>()
	}

	@Nested
	@DisplayName("when new")
	inner class WhenNew {

		@BeforeEach
		fun createNewStack() {
			stack = Stack()
		}

		@Test
		@DisplayName("is empty")
		fun isEmpty() {
			Assertions.assertTrue(stack.isEmpty())
		}

		@Test
		@DisplayName("throws EmptyStackException when popped")
		fun throwsExceptionWhenPopped() {
			Assertions.assertThrows(EmptyStackException::class.java) { stack.pop() }
		}

		@Test
		@DisplayName("throws EmptyStackException when peeked")
		fun throwsExceptionWhenPeeked() {
			Assertions.assertThrows(EmptyStackException::class.java) { stack.peek() }
		}

		@Nested
		@DisplayName("after pushing an element")
		inner class AfterPushing {

			private val anElement = "an element"

			@BeforeEach
			fun pushAnElement() {
				stack.push(anElement)
			}

			@Test
			@DisplayName("it is no longer empty")
			fun isNotEmpty() {
				Assertions.assertFalse(stack.isEmpty())
			}

			@Test
			@DisplayName("returns the element when popped and is empty")
			fun returnElementWhenPopped() {
				Assertions.assertEquals(anElement, stack.pop())
				Assertions.assertTrue(stack.isEmpty())
			}

			@Test
			@DisplayName("returns the element when peeked but remains not empty")
			fun returnElementWhenPeeked() {
				Assertions.assertEquals(anElement, stack.peek())
				Assertions.assertFalse(stack.isEmpty())
			}
		}
	}
}
