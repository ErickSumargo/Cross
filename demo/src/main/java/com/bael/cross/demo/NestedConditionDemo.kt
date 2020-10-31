package com.bael.cross.demo

/**
 * Created by ericksumargo on 01/11/20.
 */

class NestedConditionDemo {
    private val emailRegex: Regex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

    private val passwordRegex: Regex = "(/^(?=.*\\d)(?=.*[A-Z])([@\$%&#])[0-9a-zA-Z]{4,}\$/)".toRegex()

    fun isFormValid(forms: Map<String, String?>): Boolean {
        for (form in forms) {
            val (identifier, data) = form
            if (data.isNullOrEmpty()) {
                return false
            } else {
                when (identifier) {
                    "email" -> {
                        if (!(data matches emailRegex)) {
                            return false
                        }
                    }
                    "password" -> {
                        if (data.trim().length >= 8) {
                            if (!(data matches passwordRegex)) {
                                return false
                            }
                        } else {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }
}
