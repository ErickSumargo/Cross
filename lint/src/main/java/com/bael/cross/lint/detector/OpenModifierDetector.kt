package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.OpenModifierHandler
import com.bael.cross.lint.issue.ISSUE_OPEN_MODIFIER
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class OpenModifierDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        OpenModifierHandler(
            context,
            issue = ISSUE_OPEN_MODIFIER
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UClass::class.java
    )
}
