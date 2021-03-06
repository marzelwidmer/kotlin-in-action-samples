package ch.keepcalm.kt.inaction.chapter4.singeltonpattern

import java.io.File

fun main() {

    val employees = listOf(
        Person(name = "Bob", salery = 5000),
        Person(name = "Alice", salery = 500), Person(name = "John", salery = 50)
    )
    println("Sorted by names : ${employees.sortedWith(Person.NameComparator)}")
    println("Sorted by salery ${employees.sortedWith(Person.SaleryComparator)}")

    Payroll.allEmployees.addAll(employees)
    Payroll.calculateSalery()

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

data class Person(val name: String, val salery: Int = 0){
    object NameComparator : Comparator<Person>{
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }

    object SaleryComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.salery.compareTo(p2.salery)

    }
}
