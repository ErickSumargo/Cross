package com.bael.cross.lint.ext

import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.uast.UMethod

/**
 * Created by ericksumargo on 01/10/20.
 */

fun UMethod.isProperty(): Boolean {
    return sourcePsi is KtProperty
}
