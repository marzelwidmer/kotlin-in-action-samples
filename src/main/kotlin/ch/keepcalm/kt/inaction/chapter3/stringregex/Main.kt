package ch.keepcalm.kt.inaction.chapter3.stringregex

fun main(args: Array<String>): Unit {

    // 3.5.2
    parsePath("/Users/marcelwidmer/dev/git/kotlin-in-action/src/KotlinInAction.kt")
}


// 3.5.2
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

