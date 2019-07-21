package ch.keepcalm.kt.inaction.chapter4.classesobjectinterfaces

import java.io.Serializable

fun main() {
    println(
        """ 
    ____ _                         ___  _     _           _   ___       _             __
   / ___| | __ _ ___ ___  ___ ___ / _ \| |__ (_) ___  ___| |_|_ _|_ __ | |_ ___ _ __ / _| __ _  ___ ___ ___
  | |   | |/ _` / __/ __|/ _ \ __| | | | '_ \| |/ _ \/ __| __|| || '_ \| __/ _ \ '__| |_ / _` |/ __/ _ \ __|
  | |___| | (_| \__ \__ \  __\__ \ |_| | |_) | |  __/ (__| |_ | || | | | |_  __/ |  |  _| (_| | (__  __\__ \
   \____|_|\__,_|___/___/\___|___/\___/|_.__// |\___|\___|\__|___|_| |_|\__\___|_|  |_|  \__,_|\___\___|___/
                                           |__/
"""
    )

    Button().click()
    Button().showOff()
    Button().setFocus(true)
    Button().setFocus(false)

    println("Num is ${eval(Expr.Num(10))}")
    println("Sum is : ${eval(
        Expr.Sum(
            left = Expr.Num(
                10
            ), right = Expr.Num(10)
        )
    )}")

    val alice = User(nickname = "Alice")
    println("Alice subscribed  ${alice.isSubscribed}")

    val bob = User(nickname = "Bob", isSubscribed = false)
    println("Bob subscribed  ${bob.isSubscribed}")
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }

    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
    }

    override fun click() {
        println("I was clicked")
    }
}

open class RichButton : Clickable {
    fun disable() = println("I'm disabled!")
    open fun animate() = println("I animate something.")
    override fun click() {
        println("I was clicked")
    }
}

// 4.1.3
//internal open class TalkativeButton : classesObjectsInterfaces.Focusable {
//    private fun yell() = println("Hey!")
//    protected fun whisper() = println("Let's talk!")
//}
//fun TalkativeButton.giveSpeech(){
//
//}

interface State : Serializable
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {
        println("Restore classesObjectsInterfaces.State..")
    }
}
class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}


//interface classesObjectsInterfaces.Expr
//class Num(val value: Int) : classesObjectsInterfaces.Expr
//class Sum(val left: classesObjectsInterfaces.Expr, val right: classesObjectsInterfaces.Expr) : classesObjectsInterfaces.Expr
//fun classesObjectsInterfaces.eval(e: classesObjectsInterfaces.Expr): Int =
//    when (e) {
//        is Num -> e.value
//        is Sum -> classesObjectsInterfaces.eval(e.right) + classesObjectsInterfaces.eval(e.left)
//        else -> throw IllegalArgumentException("Unknown expression")
//    }

// SEALED Class you don`t need the else branch...
sealed class Expr{
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}
fun eval(e: Expr) : Int =
    when(e){
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }

// 4.2 Declaring a class with nontrivial constructors or properties
//private class User(nickname: String)
//private class User (val _nickname: String){
//    val nickname = _nickname

//    val nickname: String
//    init {
//        nickname = _nickname
//    }
//}

private open class User(val nickname: String,
           val isSubscribed: Boolean = true)
private class TwitterUser(nickname: String) : User(nickname){}



