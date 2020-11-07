package com.bael.cross.demo

/**
 * Created by ericksumargo on 01/11/20.
 */

class NamedArgumentDemo {

    fun main() {
        val result = sumOf(7, 5)
        println(result)
    }

    private fun sumOf(from: Int, to: Int): Int {
        val range = if (from <= to) from..to else from downTo to
        return range.sum()
    }
}
