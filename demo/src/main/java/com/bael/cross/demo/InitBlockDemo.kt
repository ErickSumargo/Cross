package com.bael.cross.demo

import java.io.File
import java.io.IOException

/**
 * Created by ericksumargo on 01/11/20.
 */

class InitBlockDemo {

    class FileReader(fileName: String) {
        private var content: String? = null

        init {
            try {
                content = File(fileName).readText()
            } catch (cause: IOException) {}
        }

        fun readContent(): String? = content
    }
}
