package re.seungsoo.classes

abstract class Vehicle(val name: String, val color: String, val weight: Double){

    abstract val maxSpeed:Double

    // 비추상 프로퍼티
    var year: String = "2000"

    abstract fun start()
    abstract fun stop()

    fun displaySpec(){
        println("name: $name, color: $color, weight: $weight, year: $year, maxSpeed: $maxSpeed")
    }
}

class Car(name: String, color: String,
          weight: Double,
          override val maxSpeed: Double) : Vehicle(name, color, weight){

    override fun start() {
        println("Car Started")
    }

    override fun stop() {
        println("Car Stopped")
    }

    fun autopilotOn(){
        println("AutoPilot On")
    }

}

class MotorBike(name: String, color: String,
          weight: Double,
          override val maxSpeed: Double) : Vehicle(name, color, weight){

    override fun start() {
        println("Moto Started")
    }

    override fun stop() {
        println("Moto Stopped")
    }

}

fun main(){
    var car = Car("Matiz","Red",300.0, 100.0)
    var motor = Car("Moto1","Blue",100.0, 200.0)

    car.year = "2014"
    car.autopilotOn()
    car.displaySpec()

    motor.displaySpec()
}