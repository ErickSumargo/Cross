package com.bael.cross.lint.ext

import com.intellij.psi.PsiModifier
import org.jetbrains.kotlin.psi.KtObjectDeclaration
import org.jetbrains.uast.UClass

/**
 * Created by ericksumargo on 01/10/20.
 */

fun UClass.isAbstract(): Boolean {
    return modifierList?.hasModifierProperty(PsiModifier.ABSTRACT) == true
}

fun UClass.isObjectDeclaration(): Boolean {
    return sourcePsi is KtObjectDeclaration
}
