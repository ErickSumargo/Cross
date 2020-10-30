package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.InitBlockHandler
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.issue.ISSUE_INIT_BLOCK
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class InitBlockDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        InitBlockHandler(
            context,
            issue = ISSUE_INIT_BLOCK
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UClass::class.java
    )
}
