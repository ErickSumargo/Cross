package com.bael.cross.demo

/**
 * Created by ericksumargo on 01/10/20.
 */

class NullablePrimitiveDemo {
    private var id: Int? = null

    private val flag: Boolean = false

    fun main() {
        id = 1

        println(id)
        println(flag)
        println(signedNumber())
    }

    private fun signedNumber(): Long? = 1L
}
