package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.NullablePrimitiveHandler
import com.bael.cross.lint.issue.ISSUE_NULLABLE_PRIMITIVE
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.UVariable

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class NullablePrimitiveDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        NullablePrimitiveHandler(
            context,
            issue = ISSUE_NULLABLE_PRIMITIVE
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UMethod::class.java,
        UVariable::class.java
    )
}
