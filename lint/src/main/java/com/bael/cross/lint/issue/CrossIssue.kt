@file:Suppress("UnstableApiUsage")

package com.bael.cross.lint.issue

import com.android.tools.lint.detector.api.Category.Companion.COMPLIANCE
import com.android.tools.lint.detector.api.Category.Companion.PERFORMANCE
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue.Companion.create
import com.android.tools.lint.detector.api.Scope.Companion.JAVA_FILE_SCOPE
import com.android.tools.lint.detector.api.Severity.WARNING
import com.bael.cross.lint.detector.NamedArgumentDetector
import com.bael.cross.lint.detector.NestedConditionDetector
import com.bael.cross.lint.detector.NullablePrimitiveDetector

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
