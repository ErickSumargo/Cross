package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.PublicMethodHandler
import com.bael.cross.lint.issue.ISSUE_PUBLIC_METHOD
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class PublicMethodDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        PublicMethodHandler(
            context,
            issue = ISSUE_PUBLIC_METHOD
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UClass::class.java
    )
}
