package com.bael.cross.lint.handler

import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.bael.cross.lint.ext.isProperty
import org.jetbrains.kotlin.psi.KtNullableType
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.KtUserType
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.UVariable

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class NullablePrimitiveHandler(
    context: JavaContext,
    issue: Issue
) : IssueHandler(context, issue) {
    private val primitiveTypes: Map<String, String> = hashMapOf(
        "Boolean" to "Boolean",
        "Byte" to "Byte",
        "Char" to "Char",
        "Double" to "Double",
        "Float" to "Float",
        "Int" to "Int",
        "Long" to "Long",
        "Short" to "Short"
    )

    override fun visitMethod(node: UMethod) {
        if (node.isProperty()) return
        if (!isNullablePrimitive(node)) return

        report(node, message = issueExplanation)
    }

    override fun visitVariable(node: UVariable) {
        if (!isNullablePrimitive(node)) return
        report(node, message = issueExplanation)
    }

    private fun isNullablePrimitive(node: UElement): Boolean {
        val primitiveType = node.sourcePsi
            ?.children?.find { it is KtTypeReference }
            ?.children?.find { it is KtNullableType }
            ?.children?.find { it is KtUserType }
            ?.text.orEmpty()
        return primitiveTypes[primitiveType] != null
    }
}
