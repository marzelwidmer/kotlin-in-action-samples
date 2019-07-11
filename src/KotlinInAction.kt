import java.util.*

fun main(args: Array<String>): Unit {

    val box = Box(height = 10, width = 10, name = "rectangle")
    println("is the ${box.name} a rectangle ${box.isSquare}")

    val box2 = Box(height = 41, width = 43)
    println("is the ${box2.name} a rectangle ${box2.isSquare}")

    // 2.4.3 Iterating over maps
    val binaryReps = TreeMap<Char, String>() // Sorted Map
    for (c in 'A'..'F') { // Iterate from A to F
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    // 2.26
    println(recognize('8'))
    println(recognize('a'))
    println(recognize('Z'))
    println(recognize('-'))

}
// Custom Accessors
class Box(val height: Int, val width: Int, val name: String = "Box") {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
// 2.26
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."

}
