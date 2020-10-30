package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.UtilsNamingDetector
import com.bael.cross.lint.issue.ISSUE_UTILS_NAMING
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class UtilsNamingHandlerTest : IssueHandlerTest(
    issue = ISSUE_UTILS_NAMING,
    detector = UtilsNamingDetector()
) {
    @Test
    fun `verify sut with proper utils naming case`() {
        lint().files(
            kt(
                """
                object Object
                object ObjectUtil
                object ObjectUtils
                
                object `Object`
                object `ObjectUtil`
                object `ObjectUtils`
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with improper utils naming case`() {
        lint().files(
            kt(
                """
                object Util
                object Utils
                
                object `Util`
                object `Utils`
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/Util.kt:1: $issueDescription: $issueExplanation [$issueId]
                object Util
                ~~~~~~~~~~~
                src/Util.kt:2: $issueDescription: $issueExplanation [$issueId]
                object Utils
                ~~~~~~~~~~~~
                src/Util.kt:4: $issueDescription: $issueExplanation [$issueId]
                object `Util`
                ~~~~~~~~~~~~~
                src/Util.kt:5: $issueDescription: $issueExplanation [$issueId]
                object `Utils`
                ~~~~~~~~~~~~~~
                0 errors, 4 warnings
                """
            )
    }
}
