package com.bael.cross.lint.handler

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.TextFormat.TEXT
import com.bael.cross.lint.detector.IssueDetector

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
abstract class IssueHandlerTest(
    private val issue: Issue,
    private val detector: IssueDetector
) : LintDetectorTest() {
    protected val issueId: String = issue.id
    protected val issueDescription: String = issue.defaultSeverity.description
    protected val issueExplanation: String = issue.getExplanation(TEXT)

    override fun getDetector(): Detector {
        return detector
    }

    override fun getIssues(): List<Issue> {
        return listOf(issue)
    }
}
