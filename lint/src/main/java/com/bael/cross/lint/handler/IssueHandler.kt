package com.bael.cross.lint.handler

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.TextFormat.TEXT
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
abstract class IssueHandler(
    private val context: JavaContext,
    private val issue: Issue
) : UElementHandler() {
    protected val issueExplanation: String = issue.getExplanation(TEXT)

    protected fun report(
        scope: UElement,
        message: String,
        quickFixData: LintFix? = null
    ) {
        val location = context.getLocation(scope)
        context.report(issue, scope, location, message, quickFixData)
    }
}
