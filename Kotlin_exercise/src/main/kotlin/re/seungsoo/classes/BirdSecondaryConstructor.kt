package re.seungsoo.classes

class Bird {

    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(name: String, wing: Int, beak: String, color: String){
        this.name = name
        this.wing = wing
        this.beak = beak
        this.color = color

    }

    init{
        println("------------- 초기화 불록 시작 -----------")
        this.sing(3)
    }

    fun fly() = println("Fly with wings: $wing")
    fun sing(vol:Int)= println("song with a volumn: $vol")
}

fun main(){
    val coco = Bird("myBird", 2, "short","blue")
}