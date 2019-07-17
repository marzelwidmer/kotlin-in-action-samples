import java.io.Serializable

fun main(): Unit {
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

    println("Num is ${eval(Num(10))}")
    println("Sum is : ${eval(Sum(left = Num(10), right = Num(10)))}")
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
    open fun animate() = println("I animalte something.")
    override fun click() {
        println("I was clicked")
    }
}

// 4.1.3
//internal open class TalkativeButton : Focusable {
//    private fun yell() = println("Hey!")
//    protected fun whisper() = println("Let's talk!")
//}
//fun TalkativeButton.giveSpeech(){
//
//}

interface State : Serializable
interface View {
    fun getCurrectState(): State
    fun restoreState(state: State) {
        println("Restore State..")
    }
}
class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}


interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }











