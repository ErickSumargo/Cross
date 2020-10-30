package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.NullablePrimitiveDetector
import com.bael.cross.lint.issue.ISSUE_NULLABLE_PRIMITIVE
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class NullablePrimitiveHandlerTest : IssueHandlerTest(
    issue = ISSUE_NULLABLE_PRIMITIVE,
    detector = NullablePrimitiveDetector()
) {
    @Test
    fun `verify sut with no nullable primitive(s) case`() {
        lint().files(
            kt(
                """
                class SUT {
                    private val v: Boolean = false
                    
                    private fun foo(): Int {
                        val v1: Int = 1
                        val v2: Long = -1L
                        return v1 + v2.toInt()
                    }
                    
                    companion object {
                        private fun bar(p: Float) {}
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with nullable primitive(s) as method return type case`() {
        lint().files(
            kt(
                """
                class SUT {

                    private fun foo(): Int? {}
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:3: $issueDescription: $issueExplanation [$issueId]
                    private fun foo(): Int? {}
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~
                0 errors, 1 warnings
                """
            )
    }

    @Test
    fun `verify sut with nullable primitive(s) at local variable case`() {
        lint().files(
            kt(
                """
                class SUT {
                
                    private fun foo() {
                        val v: Int? = -1
                        println(v)
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:4: $issueDescription: $issueExplanation [$issueId]
                        val v: Int? = -1
                        ~~~~~~~~~~~~~~~~
                0 errors, 1 warnings
                """
            )
    }

    @Test
    fun `verify sut with nullable primitive(s) at global variable case`() {
        lint().files(
            kt(
                """
                class SUT {
                    val v: Boolean? = false
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:2: $issueDescription: $issueExplanation [$issueId]
                    val v: Boolean? = false
                    ~~~~~~~~~~~~~~~~~~~~~~~
                0 errors, 1 warnings
                """
            )
    }
}
