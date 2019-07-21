package ch.keepcalm.kt.inaction.chapter4.companion

// 4.4.2 Companion objects: a place for factory methods and static members
fun main() {

    A.bar()
}

class A {
    companion object {
        fun bar(){
            println("Companion object called")
        }
    }
}