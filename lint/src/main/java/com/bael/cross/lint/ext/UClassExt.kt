package com.bael.cross.lint.ext

import org.jetbrains.kotlin.psi.KtObjectDeclaration
import org.jetbrains.uast.UClass

/**
 * Created by ericksumargo on 01/10/20.
 */

fun UClass.isObjectDeclaration(): Boolean {
    return sourcePsi is KtObjectDeclaration
}
