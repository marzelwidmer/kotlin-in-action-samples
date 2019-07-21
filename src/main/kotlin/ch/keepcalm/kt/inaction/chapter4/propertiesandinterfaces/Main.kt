package ch.keepcalm.kt.inaction.chapter4.propertiesandinterfaces


fun main() {
    println("PrivateUser : ${PrivateUser(nickname = "John").nickname}")
    println("SubscribingUser : ${SubscribingUser(email = "john.doe@foobar.com").nickname}")
}

// 4.2.3 Implement properties declared in Interfaces
interface User {
    val nickname: String
}
interface MyUser{
    val email: String
    val nickname : String
        get() = email.substringBefore('@')
}
class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User {
    override val nickname: String = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String = "Connect to FB ... with $accountId"

}

