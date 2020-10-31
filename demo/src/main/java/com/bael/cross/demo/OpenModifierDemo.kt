package com.bael.cross.demo

/**
 * Created by ericksumargo on 01/11/20.
 */

class OpenModifierDemo {

    interface RandomGenerator {

        fun generate(length: Int): String
    }

    open class TextRandom(val random: RandomGenerator) {

        open fun generate(length: Int): String {
            return random.generate(length)
        }
    }

    class TextNumericRandom(random: RandomGenerator) : TextRandom(random) {

        override fun generate(length: Int): String {
            val text = super.generate(length)
            return text.replace("[^0-9]".toRegex(), "")
        }
    }
}
