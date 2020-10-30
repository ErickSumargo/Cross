package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtValueArgumentList
import org.jetbrains.uast.UCallExpression

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class NamedArgumentHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitCallExpression(node: UCallExpression) {
        if (hasIdentifiedArgument(node)) return
        report(node, message = issueExplanation)
    }

    private fun hasIdentifiedArgument(node: UCallExpression): Boolean {
        val psi = node.sourcePsi?.children?.find { it is KtValueArgumentList }
        val namedArgs = (psi as? KtValueArgumentList)?.arguments?.map {
            it.getArgumentName()?.asName
        }

        for (i in node.valueArguments.indices) {
            if (i >= namedArgs?.size ?: 0) break

            when (node.valueArguments[i].sourcePsi) {
                !is KtNameReferenceExpression -> {
                    if (namedArgs?.get(i) == null) return false
                }
            }
        }
        return true
    }
}
