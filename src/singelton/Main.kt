package singelton

import java.io.File

fun main() {

    val employees = arrayListOf<Person>(
        Person(name = "Bob", salery = 1000),
        Person(name = "Alice", salery = 1000), Person(name = "John", salery = 1000)
    )

    Payroll.allEmployees.addAll(employees)
    Payroll.calculateSalery()


    // 4.23
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/C"), File("/b"), File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}


// Singelton
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalery() {
        var salery = 0
        for (person in allEmployees) {
            salery += person.salery
            println("Employee ${person.name} salery is ${person.salery}$")
        }
        println("Salery of all employees are ${salery}$")
    }
}

class Person(val name: String, val salery: Int)

// 4.23 Implementing Comparator with an object
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}
