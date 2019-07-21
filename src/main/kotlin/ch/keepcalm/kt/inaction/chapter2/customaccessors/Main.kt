package ch.keepcalm.kt.inaction.chapter2.customaccessors

fun main(args: Array<String>): Unit {
    main_box()
    // 3.4.3
    println("12.345-6.A".split("\\.|-".toRegex()))
}

fun main_box() {
    val box = Box(height = 10, width = 10, name = "rectangle")
    println("is the ${box.name} a rectangle ${box.isSquare}")

    val box2 = Box(height = 41, width = 43)
    println("is the ${box2.name} a rectangle ${box2.isSquare}")
}

// Custom Accessors
class Box(val height: Int, val width: Int, val name: String = "Box") {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
