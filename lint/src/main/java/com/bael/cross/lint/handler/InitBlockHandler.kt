package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.kotlin.psi.KtClassBody
import org.jetbrains.kotlin.psi.KtClassInitializer
import org.jetbrains.uast.UClass

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class InitBlockHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {

    override fun visitClass(node: UClass) {
        if (!hasInitBlock(node)) return
        report(node, message = issueExplanation)
    }

    private fun hasInitBlock(node: UClass): Boolean {
        return node.sourcePsi
            ?.children?.find { it is KtClassBody }
            ?.children?.find { it is KtClassInitializer } != null
    }
}
