package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.PublicMethodDetector
import com.bael.cross.lint.issue.ISSUE_PUBLIC_METHOD
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class PublicMethodHandlerTest : IssueHandlerTest(
    issue = ISSUE_PUBLIC_METHOD,
    detector = PublicMethodDetector()
) {
    @Test
    fun `verify sut with public method(s) as API contract(s) case`() {
        lint().files(
            kt(
                """
                interface API {
                    fun foo()
                }
                
                class SUT {
                    
                    override fun foo() {}
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with no public method(s) case`() {
        lint().files(
            kt(
                """
                class SUT {
                    private val v: Int = -1
                    
                    private fun foo() {}
                    
                    companion object {
                        private fun bar() {}
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with public method(s) case`() {
        lint().files(
            kt(
                """
                class SUT {
                    val v: Int = -1
                    
                    fun foo() {}
                    
                    companion object {
                        fun bar() {}
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:1: $issueDescription: $issueExplanation [$issueId]
                class SUT {
                ^
                src/SUT.kt:6: $issueDescription: $issueExplanation [$issueId]
                    companion object {
                    ^
                0 errors, 2 warnings
                """
            )
    }
}
