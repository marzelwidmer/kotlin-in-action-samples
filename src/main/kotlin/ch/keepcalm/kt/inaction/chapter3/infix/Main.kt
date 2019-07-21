package ch.keepcalm.kt.inaction.chapter3.infix

fun main(args: Array<String>): Unit {
    main_3_4_3()

    // 3.4.3
    println("12.345-6.A".split("\\.|-".toRegex()))

}


// 3.4.3
fun main_3_4_3(): Unit {
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    1.to("one")
    1 to "one" // infix form
    println(map.get(7))
}
