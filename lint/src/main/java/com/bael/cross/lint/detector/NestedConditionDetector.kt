package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.NestedConditionHandler
import com.bael.cross.lint.issue.ISSUE_NESTED_CONDITION
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UIfExpression
import org.jetbrains.uast.USwitchExpression

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class NestedConditionDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        NestedConditionHandler(
            context,
            issue = ISSUE_NESTED_CONDITION
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UIfExpression::class.java,
        USwitchExpression::class.java
    )
}
