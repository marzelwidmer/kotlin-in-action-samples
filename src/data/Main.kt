package data

// 4.3
fun main() {
    val client1 = Client(name = "Marcel", postalCode = 5620)
    val client2 = Client(name = "Marcel", postalCode = 5620)
    println("client1 == client2 ${client1 == client2}")

    val processed = hashSetOf(Client(name = "Alice", postalCode = 342562))
    println("Contains ?  ${processed.contains(Client(name = "Alice", postalCode = 342562))}")
}

class Client(val name: String, val postalCode: Int){
    override fun toString(): String {
        return "Client(name=$name, postalCode=$postalCode)"
    }

     override fun equals(other: Any?): Boolean {
         if(other == null || other !is Client)
             return false
         return name == other.name && postalCode == other.postalCode
     }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}