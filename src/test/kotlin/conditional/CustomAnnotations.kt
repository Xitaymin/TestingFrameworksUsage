package conditional

import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS

/*
Можливі умови для використання в анотаціях:
- OS
- JRE version and range
- System property
- Environment variable
- Custom condition
*/

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@DisabledIfEnvironmentVariable(named = "preCommit", matches = "true")
annotation class LongTest

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@EnabledOnOs(OS.LINUX)
annotation class OnlyLinux
