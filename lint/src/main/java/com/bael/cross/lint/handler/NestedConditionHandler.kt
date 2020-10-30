package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UIfExpression
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.USwitchExpression
import org.jetbrains.uast.kotlin.KotlinUBlockExpression
import org.jetbrains.uast.kotlin.KotlinUIfExpression
import org.jetbrains.uast.kotlin.KotlinUSwitchExpression

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class NestedConditionHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitIfExpression(node: UIfExpression) {
        if (!isNestedCondition(node)) return
        report(node, message = issueExplanation)
    }

    override fun visitSwitchExpression(node: USwitchExpression) {
        if (!isNestedCondition(node)) return
        report(node, message = issueExplanation)
    }

    private fun isNestedCondition(node: UElement?): Boolean {
        var uastParent = node
        var insideNestedBlock = false

        while (uastParent !is UMethod) {
            uastParent = uastParent?.uastParent

            when (uastParent) {
                is KotlinUBlockExpression -> insideNestedBlock = true
                is KotlinUIfExpression -> return insideNestedBlock
                is KotlinUSwitchExpression -> return true
            }
        }
        return false
    }
}
