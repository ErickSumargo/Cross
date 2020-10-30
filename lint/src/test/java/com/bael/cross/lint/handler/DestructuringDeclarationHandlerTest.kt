package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.DestructuringDeclarationDetector
import com.bael.cross.lint.issue.ISSUE_DESTRUCTURING_DECLARATION
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class DestructuringDeclarationHandlerTest : IssueHandlerTest(
    issue = ISSUE_DESTRUCTURING_DECLARATION,
    detector = DestructuringDeclarationDetector()
) {
    @Test
    fun `verify sut with no destructuring declaration case`() {
        lint().files(
            kt(
                """
                data class Data(
                    val p1: Int,
                    val p2: String
                )
                
                class SUT {
                    private val data = Data(p1 = -1, p2 = "")
                    
                    private fun foo() {
                        println(data.p1)
                        println(data.p2)
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with destructuring declaration case`() {
        lint().files(
            kt(
                """
                data class Data(
                    val p1: Int,
                    val p2: String
                )
                
                class SUT {
                    private val data = Data(p1 = -1, p2 = "")
                    
                    private fun foo() {
                        val (p1, p2) = data
                        println(p1)
                        println(p2)
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/Data.kt:10: $issueDescription: $issueExplanation [$issueId]
                        val (p1, p2) = data
                        ~~~~~~~~~~~~~~~~~~~
                0 errors, 1 warnings
                """
            )
    }
}
