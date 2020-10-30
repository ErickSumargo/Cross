package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.TemporalCouplingHandler
import com.bael.cross.lint.issue.ISSUE_TEMPORAL_COUPLING
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UField
import org.jetbrains.uast.ULocalVariable

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class TemporalCouplingDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        TemporalCouplingHandler(
            context,
            issue = ISSUE_TEMPORAL_COUPLING
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UField::class.java,
        ULocalVariable::class.java
    )
}
