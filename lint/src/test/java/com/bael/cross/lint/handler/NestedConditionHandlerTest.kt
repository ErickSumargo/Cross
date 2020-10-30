package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.bael.cross.lint.detector.NestedConditionDetector
import com.bael.cross.lint.issue.ISSUE_NESTED_CONDITION
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
@RunWith(JUnit4::class)
class NestedConditionHandlerTest : IssueHandlerTest(
    issue = ISSUE_NESTED_CONDITION,
    detector = NestedConditionDetector()
) {
    @Test
    fun `verify sut with linear (if) condition case`() {
        lint().files(
            kt(
                """
                class SUT {
                
                    private fun foo() {
                        if (false) {}
                        else if (false) {}
                        else {}
                        
                        if (false) {}
                        else if (false) {}
                        else {}
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with linear (when) condition case`() {
        lint().files(
            kt(
                """
                class SUT {
                
                    private fun foo() {
                        when {
                            false -> {}
                            else -> {}
                        }
                        
                        when {
                            false -> {}
                            else -> {}
                        }
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expectClean()
    }

    @Test
    fun `verify sut with nested (if-if) condition case`() {
        lint().files(
            kt(
                """
                class SUT {
                
                    private fun foo() {
                        if (true) {
                            if (false) {}
                            else if (false) {}
                            else {}
                        }
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:5: $issueDescription: $issueExplanation [$issueId]
                            if (false) {}
                            ^
                0 errors, 1 warnings
                """
            )
    }

    @Test
    fun `verify sut with nested (when-if) condition case`() {
        lint().files(
            kt(
                """
                class SUT {
                
                    private fun foo() {
                        when {
                            false -> {
                                if (false) {}
                                else if (false) {}
                                else {}
                            }
                            else -> {}
                        }
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:6: $issueDescription: $issueExplanation [$issueId]
                                if (false) {}
                                ^
                0 errors, 1 warnings
                """
            )
    }

    @Test
    fun `verify sut with nested (if-when) condition case`() {
        lint().files(
            kt(
                """
                class SUT {
                
                    private fun foo() {
                        if (true) { 
                            when {
                                false -> {}
                                else -> {}
                            }
                        }
                    }
                }
                """.trimIndent()
            )
        )
            .run()
            .expect(
                expectedText =
                """
                src/SUT.kt:5: $issueDescription: $issueExplanation [$issueId]
                            when {
                            ^
                0 errors, 1 warnings
                """
            )
    }
}
