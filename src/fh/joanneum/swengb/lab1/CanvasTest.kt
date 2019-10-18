package fh.joanneum.swengb.lab1

import org.junit.Assert.assertEquals
import org.junit.Test

class CanvasTest {

    @Test
    fun testGetTotalAreaForTwoObjects() {
        val canvas = Canvas()
        canvas.addShape(Rectangle("white", width = 5.0, length = 2.0))
        canvas.addShape(Circle("red", radius = 1.0))

        assertEquals(13.142, canvas.getTotalArea(), 0.001)
    }

    @Test
    fun shouldReturnZeroIfCanvasIsEmpty(){
        val canvas = Canvas()
        assertEquals(0.0, canvas.getTotalArea(), 0.001)
    }

    @Test
    fun shouldCountTwoRectanglesAndOneCircle() {
        val canvas = Canvas()
        canvas.addShape(Rectangle("white", width = 5.0, length = 2.0))
        canvas.addShape(Circle("red", radius = 1.0))
        canvas.addShape(Rectangle("blue", width = 4.5, length = 4.0))

        val countedShapes = canvas.shapesCountPerType()
        assertEquals(2,countedShapes["Rectangle"])
        assertEquals(1,countedShapes["Circle"])
    }
}