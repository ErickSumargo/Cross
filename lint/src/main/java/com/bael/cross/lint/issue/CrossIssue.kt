@file:Suppress("UnstableApiUsage")

package com.bael.cross.lint.issue

import com.android.tools.lint.detector.api.Category.Companion.COMPLIANCE
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Category.Companion.PERFORMANCE
import com.android.tools.lint.detector.api.Category.Companion.USABILITY
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue.Companion.create
import com.android.tools.lint.detector.api.Scope.Companion.JAVA_FILE_SCOPE
import com.android.tools.lint.detector.api.Severity.WARNING
import com.bael.cross.lint.detector.DestructuringDeclarationDetector
import com.bael.cross.lint.detector.InitBlockDetector
import com.bael.cross.lint.detector.NamedArgumentDetector
import com.bael.cross.lint.detector.NestedConditionDetector
import com.bael.cross.lint.detector.NullablePrimitiveDetector
import com.bael.cross.lint.detector.OpenModifierDetector
import com.bael.cross.lint.detector.PublicMethodDetector
import com.bael.cross.lint.detector.UtilsNamingDetector

/**
 * Created by ericksumargo on 01/10/20.
 */

val ISSUE_NULLABLE_PRIMITIVE = create(
    id = "NullablePrimitive",
    briefDescription = "No Meaningless Nullable Primitives",
    explanation = "Nullable primitive detected. See why and fix suggestion here (1): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-1-9a938f3768ad",
    category = PERFORMANCE,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        NullablePrimitiveDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_NAMED_ARGUMENT = create(
    id = "NamedArgument",
    briefDescription = "Kotlin’s Named Arguments",
    explanation = "Unidentified argument(s) detected. See why and fix suggestion here (2): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-1-9a938f3768ad",
    category = COMPLIANCE,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        NamedArgumentDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_NESTED_CONDITION = create(
    id = "NestedCondition",
    briefDescription = "Max. 1 Nested Condition Block Tolerance",
    explanation = "Nested condition detected. See why and fix suggestion here (4): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-1-9a938f3768ad",
    category = PERFORMANCE,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        NestedConditionDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_DESTRUCTURING_DECLARATION = create(
    id = "DestructuringDeclaration",
    briefDescription = "Destructuring Declaration? Not even once",
    explanation = "Destructuring declaration detected. See why and fix suggestion here (5): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-1-9a938f3768ad",
    category = CORRECTNESS,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        DestructuringDeclarationDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_UTILS_NAMING = create(
    id = "UtilsNaming",
    briefDescription = "It's XUtils",
    explanation = "Improper Util(s) naming detected. See why and fix suggestion here (6): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-1-9a938f3768ad",
    category = USABILITY,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        UtilsNamingDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_PUBLIC_METHOD = create(
    id = "PublicMethod",
    briefDescription = "Public Methods as API Contracts",
    explanation = "Public method(s) detected. See why and fix suggestion here (7): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-2-426084b9c9a1",
    category = USABILITY,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        PublicMethodDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_INIT_BLOCK = create(
    id = "InitBlock",
    briefDescription = "Constructors Should Be Code-Free",
    explanation = "init block detected. See why and fix suggestion here (9): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-2-426084b9c9a1",
    category = PERFORMANCE,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        InitBlockDetector::class.java,
        JAVA_FILE_SCOPE
    )
)

val ISSUE_OPEN_MODIFIER = create(
    id = "OpenModifier",
    briefDescription = "A Class is Either Final or Abstract",
    explanation = "open modifier detected. See why and fix suggestion here (10): https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-2-426084b9c9a1",
    category = USABILITY,
    priority = 10,
    severity = WARNING,
    implementation = Implementation(
        OpenModifierDetector::class.java,
        JAVA_FILE_SCOPE
    )
)
