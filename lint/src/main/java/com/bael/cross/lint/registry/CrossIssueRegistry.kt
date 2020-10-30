package com.bael.cross.lint.registry

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.bael.cross.lint.issue.ISSUE_DESTRUCTURING_DECLARATION
import com.bael.cross.lint.issue.ISSUE_INIT_BLOCK
import com.bael.cross.lint.issue.ISSUE_NAMED_ARGUMENT
import com.bael.cross.lint.issue.ISSUE_NESTED_CONDITION
import com.bael.cross.lint.issue.ISSUE_NULLABLE_PRIMITIVE
import com.bael.cross.lint.issue.ISSUE_OPEN_MODIFIER
import com.bael.cross.lint.issue.ISSUE_PUBLIC_METHOD
import com.bael.cross.lint.issue.ISSUE_UTILS_NAMING

/**
 * Created by ericksumargo on 01/10/20.
 */

@Suppress("UnstableApiUsage")
class CrossIssueRegistry : IssueRegistry() {
    override val api: Int = CURRENT_API

    override val issues: List<Issue>
        get() = listOf(
            ISSUE_NULLABLE_PRIMITIVE,
            ISSUE_NAMED_ARGUMENT,
            ISSUE_NESTED_CONDITION,
            ISSUE_DESTRUCTURING_DECLARATION,
            ISSUE_UTILS_NAMING,
            ISSUE_PUBLIC_METHOD,
            ISSUE_INIT_BLOCK,
            ISSUE_OPEN_MODIFIER
        )
}
