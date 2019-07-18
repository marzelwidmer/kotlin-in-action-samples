package props.backingfield

fun main() {
    val user = User(name = "Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

}
class User(val name: String){
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}