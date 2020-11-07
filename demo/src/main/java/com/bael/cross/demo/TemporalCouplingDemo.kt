package com.bael.cross.demo

import kotlin.math.pow
import kotlin.properties.Delegates

/**
 * Created by ericksumargo on 01/11/20.
 */

class TemporalCouplingDemo {

    class Circle {
        var radius: Int by Delegates.notNull()

        fun calculateArea(): Double {
            return Math.PI * radius.toDouble().pow(n = 2)
        }
    }

    fun main() {
        val circle = Circle()
        circle.radius = 5

        val area = circle.calculateArea()
        println(area)
    }
}
