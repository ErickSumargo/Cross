package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.TemporalCouplingDetector
import com.bael.cross.lint.issue.ISSUE_TEMPORAL_COUPLING
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class TemporalCouplingHandlerTest : IssueHandlerTest(
    issue = ISSUE_TEMPORAL_COUPLING,
    detector = TemporalCouplingDetector()
) {
    @Test
    fun `verify sut with no potential temporal coupling case`() {
        lint().files(
            kt(
                """
                class SUT {
                    val v = ""
                    
                    private fun foo() {
                        val p = 0
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with potential temporal coupling case`() {
        lint().files(
            kt(
                """
                class SUT {
                    var v = ""
                    
                    private fun foo() {
                        var p = 0
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:2: $issueDescription: $issueExplanation [$issueId]
                    var v = ""
                    ~~~~~~~~~~
                src/SUT.kt:5: $issueDescription: $issueExplanation [$issueId]
                        var p = 0
                        ~~~~~~~~~
                0 errors, 2 warnings
                """
            )
    }
}
