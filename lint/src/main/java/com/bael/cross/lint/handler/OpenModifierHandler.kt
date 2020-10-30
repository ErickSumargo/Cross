package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.ext.isAbstract
import org.jetbrains.uast.UClass

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class OpenModifierHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitClass(node: UClass) {
        if (node.isFinal) return
        if (node.isAbstract()) return

        report(node, message = issueExplanation)
    }
}
