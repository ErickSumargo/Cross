package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.OpenModifierDetector
import com.bael.cross.lint.issue.ISSUE_OPEN_MODIFIER
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class OpenModifierHandlerTest : IssueHandlerTest(
    issue = ISSUE_OPEN_MODIFIER,
    detector = OpenModifierDetector()
) {
    @Test
    fun `verify sut with final modifier case`() {
        lint().files(
            kt(
                """
                class SUT
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with abstract modifier case`() {
        lint().files(
            kt(
                """
                abstract class SUT
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with private modifier case`() {
        lint().files(
            kt(
                """
                private class SUT
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with open modifier case`() {
        lint().files(
            kt(
                """
                open class SUT
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:1: $issueDescription: $issueExplanation [$issueId]
                open class SUT
                ~~~~~~~~~~~~~~
                0 errors, 1 warnings
                """
            )
    }
}
