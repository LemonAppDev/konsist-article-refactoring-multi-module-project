import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assert
import org.junit.jupiter.api.Test

class UseCaseKonsistTest {
    @Test
    fun `featureCaloryCalculator classes with 'UseCase' suffix should have a public method named 'invoke'`() {
        Konsist
            .scopeFromModule("featureCaloryCalculator")
            .classes()
            .assert {
                it.containsFunction { function ->
                    function.name == "invoke" && function.hasPublicOrDefaultModifier
                }
            }
    }
}
