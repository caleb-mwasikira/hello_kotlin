import kotlin.system.exitProcess

class Person(
    val name: String,
    age: Int,
    hobby: String?=null,
    val referrer: Person?=null
) {
    var age: Int = age
        set(value) {
            if (value in 0..100) {
                field = value
            } else {
                // preferably throw an IllegalArgumentException
                println("invalid age argument: valid age must be between 0 and 100")
                exitProcess(1)
            }
        }
    var hobby: String? = hobby
        get() {
            return if (field == null) "Doesn't have a hobby" else "Likes to $field"
        }

    fun showProfile() {
        val referrerMessage: String = if (referrer == null) {
            "Doesn't have a referrer"
        } else {
            "Has a referrer named ${referrer.name}, who ${referrer.hobby?.lowercase()}"
        }

        println("Name: $name\n" +
                "Age: $age\n" +
                "Hobby: $hobby. $referrerMessage\n\n"
        )
    }
}

fun main() {
    val amanda = Person(name="Amanda", age=33, hobby="play tennis", referrer=null)
    val atiqah = Person(name="Atiqah", age=28, hobby="climb", referrer=amanda)

    amanda.showProfile()
    atiqah.showProfile()
}
