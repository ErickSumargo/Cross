package com.bael.cross.lint.detector

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Detector.UastScanner
import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.handler.IssueHandler
import org.jetbrains.uast.UElement

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
abstract class IssueDetector :
    Detector(),
    UastScanner {
    abstract val issueHandler: (JavaContext) -> IssueHandler

    abstract val declarations: List<Class<out UElement>>

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return issueHandler(context)
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return declarations
    }
}
