package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.ext.isObjectDeclaration
import org.jetbrains.uast.UClass

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class UtilsNamingHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitClass(node: UClass) {
        if (!node.isObjectDeclaration()) return
        if (isProperUtilsNaming(node)) return

        report(node, message = issueExplanation)
    }

    private fun isProperUtilsNaming(node: UClass): Boolean {
        return node.name
            .orEmpty()
            .trim { c -> c in listOf('`') }
            .toLowerCase()
            .indexOf("util") != 0
    }
}
