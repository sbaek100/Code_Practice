package re.seungsoo.highorder

class HighOrder {
}
/*
고차함수 및 람다함수에 대한 내용
 */


fun main(){
    // 변수에 함수 return 넣기
    println("FuncFunc: ${funcFunc()}")

    // 일반 변수에 람다식 할당
    var result: Int
    val multi = {x: Int, y:Int -> x*y}
    result = multi(10, 20)
    println("Ramda Result: $result")

    // 람다 표현식이 2줄 이상일 때
    val multi2: (Int, Int) -> Int = { x: Int, y:Int->
        print("x*y = ")
        x*y // 마지막 표현식이 반환이 되는 것임.
    }
    println(multi2(4,5))
    // 자료형의 생략
    val multi3: (Int, Int) -> Int = {x: Int, y:Int -> x*y} // 전체 표현
    val multi4 = {x:Int, y:Int -> x* y} // 선언 자료형 생략
    val multi5: (Int, Int)-> Int = {x, y -> x*y} // 람다식 매개 변수로서 생략

    // 반환 자료형이 없거나 매개 변수가 하나 있을 경우
    val greet: ()-> Unit = {println("Hello Greet")}
    greet() // 그냥 함수처럼 사용한다.

    val square: (Int)->Int = {x -> x*x}
    println("Square : ${square(5)}")

    // 람다식 안에 람다식이 있는 경우
    val nestedLambda: ()->()->Unit = {{ println("Nested")}}
    nestedLambda()() // 괄호 안에 안에 있다는 의미 이다.

}

fun sum (a: Int, b:Int): Int = a + b

fun funcFunc(): Int{
    return sum(2,2)
}