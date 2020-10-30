package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.kotlin.lexer.KtTokens.VAR_KEYWORD
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.uast.UField
import org.jetbrains.uast.ULocalVariable
import org.jetbrains.uast.UVariable

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class TemporalCouplingHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitField(node: UField) {
        if (!isMutableVariable(node)) return
        report(node, message = issueExplanation)
    }

    override fun visitLocalVariable(node: ULocalVariable) {
        if (!isMutableVariable(node)) return
        report(node, message = issueExplanation)
    }

    private fun isMutableVariable(node: UVariable): Boolean {
        val keyword = (node.sourcePsi as? KtProperty)?.valOrVarKeyword
        return keyword?.text.orEmpty() == VAR_KEYWORD.value
    }
}
