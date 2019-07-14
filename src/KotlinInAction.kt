import java.util.*

fun main(args: Array<String>): Unit {
    main_box()
    main_2_4_3()
    main_2_26()
    main_3_4_3()

    // 3.4.3
    println("12.345-6.A".split("\\.|-".toRegex()))

    // 3.5.2
    parsePath("/Users/marcelwidmer/dev/git/kotlin-in-action/src/KotlinInAction.kt")

    // 3.6
    saveUser(User(id = 1, name = "John", address = "Wallstreet"))
    saveUser(User(id=2, name =  "", address = ""))
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

// 2.4.3
fun main_2_4_3() {
    // 2.4.3 Iterating over maps
    val binaryReps = TreeMap<Char, String>() // Sorted Map
    for (c in 'A'..'F') { // Iterate from A to F
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

// 2_26
fun main_2_26() {
    // 2.26
    println(recognize('8'))
    println(recognize('a'))
    println(recognize('Z'))
    println(recognize('-'))
}

// 2.26
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."

}

// 3.4.3
fun main_3_4_3(): Unit {
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    1.to("one")
    1 to "one" // infix form
    println(map.get(7))
}

// 3.5.2
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

// 3.6
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User){
    // 3.11
//    if (user.name.isEmpty()){
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
//    }
//    if (user.address.isEmpty()){
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
//    }

    // 3.12
//    fun validate(user: User, value: String, fieldName: String){
//        if (value.isEmpty()){
//            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
//        }
//    }
//    validate(user, user.name, "Name")
//    validate(user, user.address, "Address")

    // 3.14
    user.validateBeforeSave()

    // Save user to the database
    println("Store user with id: ${user.id} in database")
}
// 3.14
fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException("Can't save user $id}: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}