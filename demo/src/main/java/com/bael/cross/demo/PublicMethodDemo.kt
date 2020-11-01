package com.bael.cross.demo

/**
 * Created by ericksumargo on 01/11/20.
 */

class PublicMethodDemo {

    interface RandomGenerator {

        fun generate(length: Int): String
    }

    class TextRandom(val random: RandomGenerator) {

        fun generate(length: Int): String {
            return random.generate(length)
        }
    }
}
