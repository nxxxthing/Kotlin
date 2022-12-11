import java.lang.Double.max
import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt

class Lab6() {
    fun task1()
    {
        print("Enter a: ")
        val a:Double = readLine()!!.toDouble()

        print("Enter b: ")
        val b:Double = readLine()!!.toDouble()

        print("Enter c: ")
        val c:Double = readLine()!!.toDouble()

        print("Enter d: ")
        val d:Double = readLine()!!.toDouble()

        print("Enter x: ")
        val x:Double = readLine()!!.toDouble()

        println("\nResult for у=МАХ(a, b, c, d): ${func1x(a, b, c, d)}")
        println("Result for y=x^4: ${func2x(x)}")
        println("Result for y=a*(x^2) + bx + c: ${func3x(a, b, c, x)}")
    }

    private fun func1x(a: Double, b: Double, c: Double, d: Double): Double {
        return max(a, max(b, max(c, d)))
    }

    private fun func2x(x: Double): Double {
        return x.pow(4)
    }

    private fun func3x(a: Double, b: Double, c: Double, x: Double): Double {
        return a * x.pow(2) + b*x + c
    }

    fun task2() {
        print("Enter a: ")
        val a:Double = readLine()!!.toDouble()

        print("Enter b: ")
        val b:Double = readLine()!!.toDouble()

        print("Enter c: ")
        val c:Double = readLine()!!.toDouble()

        print("Enter y: ")
        val y:Double = readLine()!!.toDouble()

        println("\nResult for y=x^4: ${func1y(y)}")
        println("Result for y=a*(x^2) + bx + c: ${func2y(a, b, c, y)}")
        println("Result for у=ax + c: ${func3y(a, c, y)}")
    }

    private fun func1y(y: Double): Double {
        return y.pow(0.25) // 0.25 == 1/4
    }

    private fun func2y(a: Double, b: Double, c: Double, y: Double): String {
        if (a == 0.0) { // if a is 0, it is easier to solve
            if (b == 0.0) { // if b is also 0 we don't have x, so we can't find a solution
                return "Wrong arguments"
            }
            return ((y - c)/b).toString() // for when a is 0 we have y = bx + c, so x = (y - c)/b
        }
        val x1: Double
        val x2: Double
        // To solve this equation we will make default quadratic equation, so we need to get 0 instead of y
        val newC: Double = c - y

        // finding discriminant (later - D)
        val disc = b * b - 4.0 * a * newC

        return if (disc > 0) { // if D more than 0 we have 2 solutions
            x1 = (-b + sqrt(disc)) / (2 * a)
            x2 = (-b - sqrt(disc)) / (2 * a)
            "$x1 and $x2"
        } else if (disc == 0.0) { // if D is 0 we have only 1 solution
            x2 = -b / (2 * a)
            x1 = x2
            x1.toString()
        } else { // if D less than 0 we have imaginary parts
            val realPart = -b / (2 * a)
            val imaginaryPart = sqrt(-disc) / (2 * a)
            "$realPart+${imaginaryPart}i and $realPart-${imaginaryPart}i"
        }
    }

    private fun func3y(a: Double, c: Double, y: Double): Double {
        return (y - c)/a
    }
}

fun main() {
    val lab6 = Lab6()

    var taskNumber: Int
    do {
        print("Pick a task (1 or 2): ")
        taskNumber = readLine()!!.toInt()
    } while (taskNumber != 1 && taskNumber != 2)

    if (taskNumber == 1) {
        lab6.task1()
    } else {
        lab6.task2()
    }
}