open class Phone(
    deviceName: String = "Unknown",
    var isLightOn: Boolean = false
){
    val deviceName: String = deviceName
        get() {
            return field.lowercase()
        }

    open fun switchOn() {
        isLightOn = true
    }

    fun switchOff() {
        isLightOn = false
    }

    fun checkStatus() {
        val onOrOff: String = if (isLightOn) "on" else "off"
        println("device ($deviceName): The phone screen's light is $onOrOff")
    }
}

class FoldablePhone(
    deviceName: String = "Unknown",
    var isFolded: Boolean = true
) : Phone(
    deviceName=deviceName,
    isLightOn=!isFolded
) {
    override fun switchOn() {
        if (!isFolded) {
            isLightOn = true
        } else {
            println("device ($deviceName): cannot switch on screen while phone is folded")
        }
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}

fun main() {
    val amandasPhone = Phone(deviceName="Amanda", isLightOn=false)
    amandasPhone.switchOn()
    amandasPhone.checkStatus()
    println()

    val lindasPhone = FoldablePhone(deviceName="Linda", isFolded=true)
    lindasPhone.fold()
    lindasPhone.switchOn()
    lindasPhone.checkStatus()

    lindasPhone.unfold()
    lindasPhone.switchOn()
    lindasPhone.checkStatus()
}