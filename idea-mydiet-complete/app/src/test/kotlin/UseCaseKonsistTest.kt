import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assert
import org.junit.jupiter.api.Test

class UseCaseKonsistTest {
    @Test
    fun `classes with 'UseCase' suffix should have a public method named 'invoke'`() {
        Konsist
            .scopeFromProduction()
            .classes()
            .assert {
                val hasSingleInvokeMethod = it.containsFunction { function ->
                    function.name == "invoke" && function.hasPublicOrDefaultModifier
                }

                val hasSinglePublicDeclaration = it.numPublicOrDefaultDeclarations() == 1

                hasSingleInvokeMethod && hasSinglePublicDeclaration
            }
    }

    @Test
    fun `classes with 'UseCase' suffix should reside in feature, domain, usecase packages`() {
        Konsist.scopeFromProduction()
            .classes()
            .withNameEndingWith("UseCase")
            .assert {
                val featurePackageName = it
                    .containingFile
                    .moduleName
                    .lowercase()
                    .removePrefix("feature")

                val expected = "..${featurePackageName}.domain.usecase"
                val actual = it.packagee?.fullyQualifiedName

                it.resideInPackage("..${featurePackageName}.domain.usecase..")
            }
    }
}
