package re.seungsoo.data

data class Customer(var name:String, var email:String){

    var job:String = "Unknown"
    constructor(name:String, email:String, _job:String) : this(name, email){
        job = _job
    }

    init{
        this.name = "Mr." + this.name
    }
}

fun main(){
    val cus1 = Customer("KillDong","kil@.com")
    println(cus1)
    val (name, email)=cus1
    println("name= $name, email=$email")

    val n1 = cus1.component1()
    val n2 = cus1.component2()
    val n3 = cus1.job
    println("name = $n1, email = $email, job = $n3")

    val lam1 = {
        (name, email): Customer ->
        println(name)
        println(email)
    }
     lam1(cus1)
}

