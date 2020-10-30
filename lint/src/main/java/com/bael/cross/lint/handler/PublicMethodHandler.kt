package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.ext.isAbstract
import com.intellij.psi.PsiModifier.PRIVATE
import org.jetbrains.kotlin.lexer.KtTokens.OVERRIDE_KEYWORD
import org.jetbrains.uast.UClass

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class PublicMethodHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitClass(node: UClass) {
        if (node.isAnnotationType) return
        if (node.isInterface) return
        if (node.isAbstract()) return
        if (!hasPublicMethod(node)) return

        report(node, message = issueExplanation)
    }

    private fun hasPublicMethod(node: UClass): Boolean {
        for (method in node.methods) {
            if (method.isConstructor) continue
            if (method.hasModifierProperty(PRIVATE)) continue

            if (!method.modifierList.text.contains(OVERRIDE_KEYWORD.value)) return true
        }
        return false
    }
}
