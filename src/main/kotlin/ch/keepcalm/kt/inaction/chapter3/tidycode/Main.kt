package ch.keepcalm.kt.inaction.chapter3.tidycode

fun main(args: Array<String>): Unit {

    // 3.6
    saveUser(User(id = 1, name = "John", address = "Wallstreet"))
    saveUser(User(id = 2, name = "", address = ""))
}


// 3.6
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    // listing 3.11
//    if (user.name.isEmpty()){
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
//    }
//    if (user.address.isEmpty()){
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
//    }

    // listing 3.12
//    fun validate(user: classesObjectsInterfaces.User, value: String, fieldName: String){
//        if (value.isEmpty()){
//            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
//        }
//    }
//    validate(user, user.name, "Name")
//    validate(user, user.address, "Address")

    // listing 3.14
    user.validateBeforeSave()

    // Save user to the database
    println("Store user with id: ${user.id} in database")
}

// listing 3.14
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id}: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}