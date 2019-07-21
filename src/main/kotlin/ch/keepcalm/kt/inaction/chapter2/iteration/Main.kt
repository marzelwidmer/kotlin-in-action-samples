package ch.keepcalm.kt.inaction.chapter2.iteration

import java.util.*

fun main(args: Array<String>): Unit {
    main_2_4_3()
    main_2_26()
}

// 2.4.3
fun main_2_4_3() {
    // 2.4.3 Iterating over maps
    val binaryReps = TreeMap<Char, String>() // Sorted Map
    for (c in 'A'..'F') { // Iterate from A to F
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

// 2_26
fun main_2_26() {
    // 2.26
    println(recognize('8'))
    println(recognize('a'))
    println(recognize('Z'))
    println(recognize('-'))
}

// 2.26
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."

}
