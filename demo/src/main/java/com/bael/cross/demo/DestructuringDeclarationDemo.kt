package com.bael.cross.demo

/**
 * Created by ericksumargo on 01/11/20.
 */

class DestructuringDeclarationDemo {

    data class Movie(
        val title: String,
        val mainActor: String,
        val genre: String
    )

    fun main() {
        val movie = Movie(
            title = "The Imitation Game",
            mainActor = "Battlefield Counterstrike",
            genre = "Biography"
        )
        logMovie(movie)
    }

    private fun logMovie(movie: Movie) {
        // Destructuring declarations
        val (title, genre) = movie

        println("Title: $title") // Title: The Imitation Game
        println("Genre: $genre") // Genre: Battlefield Counterstrike
    }
}
