package fh.joanneum.swengb.lab1


open class Shape(val color:String = "black") {
    open fun getArea():Double {
        return 0.0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Shape

        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        return color.hashCode()
    }

}

class Canvas() {
    private var shapes = mutableListOf<Shape>()

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun getTotalArea(): Double {
        return shapes.sumByDouble { it.getArea() }
    }

    fun shapesCountPerType(): Map<String, Int> {
        return shapes.groupBy { it.javaClass.simpleName }.mapValues { it.value.size }
    }
}


class Rectangle(color:String = "black", val width:Double = 1.0, val length:Double = 1.0): Shape(color){
     override fun getArea(): Double {   // make use of smart completion in IntelliJ (Alt+Enter), Ctrl+Space
        return width * length
    }

    override fun toString(): String {
        return "Rectangle(width=$width, length=$length)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Rectangle

        if (width != other.width) return false
        if (length != other.length) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + width.hashCode()
        result = 31 * result + length.hashCode()
        return result
    }


}

class Circle(color:String = "black", val radius:Double = 1.0): Shape(color) {
    override fun getArea(): Double {   // make use of smart completion in IntelliJ (Alt+Enter), Ctrl+Space
        return radius * radius * Math.PI


    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Circle

        if (color != other.color) return false
        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + radius.hashCode()
        return result
    }

    override fun toString(): String {
        return "Circle(radius = $radius)"

    }
}



fun main() {
    val testShape = Shape("black")
    println(testShape.color) // black

    val testRectangle = Rectangle(width = 5.0, length = 2.0)
    println(testRectangle.getArea()) // 10.0
    testRectangle.length // 2

    val testCircle = Circle(radius = 2.0, color = "red")
    println(testCircle.getArea())
    testCircle.radius

    val circle1 = Circle(radius = 10.0, color = "red")
    val circle2 = Circle(radius = 10.0, color = "red")


    println(circle1 === circle2) // false - checking referential integrity
    println(circle1 == circle2) // false - checking structural integrity
    println(setOf<Circle>(circle1, circle2).size) // 2 elements in the set


    val rect1 = Rectangle(width = 10.0, length = 2.0, color = "yellow")
    val rect2 = Rectangle(width = 20.0, length = 3.0, color = "red")

    println(rect1 === rect2)
    println(rect1 == rect2)
    println(setOf<Rectangle>(rect1, rect2).size)

    val canvas = Canvas()
    canvas.addShape(Rectangle("white", width = 5.0, length = 2.0))
    canvas.addShape(Circle("red", radius = 1.0))
    println(canvas.getTotalArea()) //  13.14



}

