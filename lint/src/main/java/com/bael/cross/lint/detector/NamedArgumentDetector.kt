package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.NamedArgumentHandler
import com.bael.cross.lint.issue.ISSUE_NAMED_ARGUMENT
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class NamedArgumentDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        NamedArgumentHandler(
            context,
            issue = ISSUE_NAMED_ARGUMENT
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UCallExpression::class.java
    )
}
