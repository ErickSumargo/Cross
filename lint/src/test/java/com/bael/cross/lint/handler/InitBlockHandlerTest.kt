package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.InitBlockDetector
import com.bael.cross.lint.issue.ISSUE_INIT_BLOCK
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class InitBlockHandlerTest : IssueHandlerTest(
    issue = ISSUE_INIT_BLOCK,
    detector = InitBlockDetector()
) {
    @Test
    fun `verify sut with no init block case`() {
        lint().files(
            kt(
                """
                class SUT(p: Int) {
                    
                    private fun foo() {}
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with init block case`() {
        lint().files(
            kt(
                """
                class SUT(p: Int) {
                
                    init { println(p) }
                    
                    private fun foo() {}
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:1: $issueDescription: $issueExplanation [$issueId]
                class SUT(p: Int) {
                ^
                0 errors, 1 warnings
                """
            )
    }
}
