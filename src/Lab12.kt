import kotlin.math.max

enum class Weekd(val day: Int) {
    Monday(1),
    Tuesday(2),
    Wednesday(3),
    Thursday(4),
    Friday(5),
    Saturday(6),
    Sunday(7),
}

class Lab12 () {
    fun task1() {
        print("Enter symbol: ")
        val c: Char = readLine()!![0]

        if ('0'.code <= c.code && '9'.code >= c.code) {
            println("'$c' is a digit")
        } else if ('a'.code <= c.code && 'z'.code >= c.code) {
            println("'$c' is a lowercase latin symbol")
        } else if ('A'.code <= c.code && 'Z'.code >= c.code) {
            println("'$c' is an uppercase latin symbol")
        } else {
            println("'$c' is something else")
        }
    }

    fun task2() {
        print("Enter day of the week: ")
        val dayNumber: Int = readLine()!!.toInt()

        val day = findDayByNumber(dayNumber)

        if (day == null) {
            println("Day $dayNumber doesn't exists")
        } else {
            println("Day number $dayNumber is ${day.name}")
        }
    }

    fun task3() {
        print("Enter day of the week: ")
        var dayNumber: Int = readLine()!!.toInt()

        dayNumber = max((dayNumber + 1).mod(8), 1)
        val day = findDayByNumber(dayNumber)

        println("Tomorrow is ${day?.name}")
    }

    fun task4() {
        print("Enter first number: ")
        val a: Double = readLine()!!.toDouble()

        print("Enter second number: ")
        val b: Double = readLine()!!.toDouble()

        print("Enter operation: ")
        val c: Char = readLine()!![0]

        println(when (c) {
            '-' -> "$a $c $b = ${a - b}"
            '+' -> "$a $c $b = ${a + b}"
            '*' -> "$a $c $b = ${a * b}"
            '/' -> {
                if (b == 0.0) {
                    "Cannot divide by 0"
                } else {
                    "$a $c $b = ${a / b}"
                }
            }
            else -> "$c is not a valid mathematical operation"
        })

    }
    fun task5() {
        print("Enter N: ")
        val n: Int = readLine()!!.toInt()
        if (n <= 3) {
            println("Wrong args!")
            return
        }
        var result = Int.MAX_VALUE
        var a: Int? = null
        var b: Int? = null

        for (tempA in (0..1000)) {
            for (tempB in (0..1000)) {
                if (5*tempA - 2*tempB == n && tempA + tempB < result) {
                    a = tempA
                    b = tempB
                    result = a + b
                }
            }
        }

        if (a == null) {
            println("Result for $n not found")
        } else {
            println("a is $a and b is $b")
        }

    }

    private fun findDayByNumber(n: Int): Weekd? {
        for (day in Weekd.values()) {
            if (n == day.day) {
                return day
            }
        }
        return null
    }
}

fun main() {
    val lab12 = Lab12()

    var taskNumber:Int
    do {
        print("\nEnter task number(from 1 to 5): ")
        taskNumber = readLine()!!.toInt()
    } while (taskNumber < 1 || taskNumber > 5)

    when (taskNumber) {
        1-> {lab12.task1()}
        2-> {lab12.task2()}
        3-> {lab12.task3()}
        4-> {lab12.task4()}
        5-> {lab12.task5()}
    }
}