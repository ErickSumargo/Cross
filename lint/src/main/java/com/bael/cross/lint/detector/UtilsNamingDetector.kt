package com.bael.cross.lint.detector

import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import com.bael.cross.lint.handler.UtilsNamingHandler
import com.bael.cross.lint.issue.ISSUE_UTILS_NAMING
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class UtilsNamingDetector : IssueDetector() {
    override val issueHandler: (JavaContext) -> IssueHandler = { context ->
        UtilsNamingHandler(
            context,
            issue = ISSUE_UTILS_NAMING
        )
    }

    override val declarations: List<Class<out UElement>> = listOf(
        UClass::class.java
    )
}
