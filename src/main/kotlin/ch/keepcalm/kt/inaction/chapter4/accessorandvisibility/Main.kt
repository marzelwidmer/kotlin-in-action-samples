package ch.keepcalm.kt.inaction.chapter4.accessorandvisibility

fun main() {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Basco")
    println(lengthCounter.counter)
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}