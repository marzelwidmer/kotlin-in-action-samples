package ch.keepcalm.kt.inaction.chapter4.comperator

import java.io.File

fun main() {

    // 4.23
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/C"), File("/b"), File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}

// 4.23 Implementing Comparator with an object
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}
