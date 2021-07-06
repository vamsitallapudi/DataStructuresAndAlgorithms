package main.concepts.kotlin

data class Puppy(
    val name: String,
    val breed: String,
    var cuteness : Int = 5
)
//creating new instances
val choco = Puppy(name = "choco", breed = "pug", cuteness = Int.MAX_VALUE)
val dinnu = Puppy(name = "choco", breed = "pug", cuteness = 4)

fun main() {
//    access and modify properties
    println(dinnu.breed)
    println(dinnu.cuteness++)

//    destructuring
//    val (nam)
}
