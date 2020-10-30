package com.bael.cross.lint.registry

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.bael.cross.lint.issue.ISSUE_NULLABLE_PRIMITIVE

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class CrossIssueRegistry : IssueRegistry() {
    override val api: Int = CURRENT_API

    override val issues: List<Issue>
        get() = listOf(
            ISSUE_NULLABLE_PRIMITIVE
        )
}
