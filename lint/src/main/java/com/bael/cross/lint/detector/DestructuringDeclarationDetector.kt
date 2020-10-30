package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.DestructuringDeclarationHandler
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.issue.ISSUE_DESTRUCTURING_DECLARATION
import org.jetbrains.uast.UDeclarationsExpression
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class DestructuringDeclarationDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        DestructuringDeclarationHandler(
            context,
            issue = ISSUE_DESTRUCTURING_DECLARATION
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UDeclarationsExpression::class.java
    )
}
