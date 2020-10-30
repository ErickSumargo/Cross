package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.kotlin.KtNodeTypes.DESTRUCTURING_DECLARATION
import org.jetbrains.uast.UDeclarationsExpression
import org.jetbrains.uast.getAnchorPsi

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class DestructuringDeclarationHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitDeclarationsExpression(node: UDeclarationsExpression) {
        if (!isDestructuringDeclaration(node)) return
        report(node, message = issueExplanation)
    }

    private fun isDestructuringDeclaration(node: UDeclarationsExpression): Boolean {
        val elementType = node.declarations.firstOrNull()?.getAnchorPsi()?.parent?.node?.elementType
        return elementType == DESTRUCTURING_DECLARATION
    }
}
