package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.NamedArgumentDetector
import com.bael.cross.lint.issue.ISSUE_NAMED_ARGUMENT
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class NamedArgumentHandlerTest : IssueHandlerTest(
    issue = ISSUE_NAMED_ARGUMENT,
    detector = NamedArgumentDetector()
) {
    @Test
    fun `verify sut with named argument(s) including lambda(s) as argument case`() {
        lint().files(
            kt(
                """
                class SUT {
                    private val arr = IntArray(size = 10, init = { -1 })
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with named argument(s) but lambda case`() {
        lint().files(
            kt(
                """
                class SUT {
                    private val arr = IntArray(size = 10) { -1 }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with no named argument(s) case`() {
        lint().files(
            kt(
                """
                class SUT {
                    private val arr = IntArray(10) { -1 }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:2: $issueDescription: $issueExplanation [$issueId]
                    private val arr = IntArray(10) { -1 }
                                      ~~~~~~~~~~~~~~~~~~~
                0 errors, 1 warnings
                """
            )
    }
}
