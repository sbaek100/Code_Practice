package re.seungsoo.highorder

class callByValue {
}

fun main(){

    val result = callByValue(lambda())
    println(result)

   println( funcParam(3, 2 , ::sum2) )

}

fun callByValue(b: Boolean): Boolean {
    println("Call By Value Function")
    return b
}

val lambda: () -> Boolean = {
    println("lambda function")
    true
}

fun sum2(x: Int, y:Int) = x+y

fun funcParam(a: Int, b:Int, c:(Int, Int)->Int): Int{
    return c(a,b)
}