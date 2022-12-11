import kotlin.math.abs

class Lab7 {
    //fib(n) = fib(n-1) + fib(n-2)
    fun fib(n: Int): Array<Int> {
        if (n <= 0) {
            println("0 - 0")
            return arrayOf(1, 0); // we will return 2 last numbers so we can get result for n+1
        }
        var previous: Array<Int> = fib(n - 1) // we will get array with [fib(n-2), fib(n-1)]
        val result = previous.last() + previous.first()
        println("$n - $result")
        return arrayOf(previous.last(), result)
    }

    fun fact(n: Int): Int {
        if (n <= 0) {
            return 1;
        }
        return n * fact(n-1)
    }

    fun countDigits(n: Int): Int {
        if (n < 10) {
            return 1
        }

        return 1 + countDigits(n.div(10))
    }
}

fun main() {
    print("Enter n: ")
    val n:Int = readLine()!!.toInt()
    val lab7 = Lab7()

    var taskNumber:Int
    do {
        print("\n1 - fibonacci\n2 - factorial\n3 - number of digits\nEnter your choice: ")
        taskNumber = readLine()!!.toInt()
    } while (taskNumber != 1 && taskNumber != 2 && taskNumber != 3)

    when (taskNumber) {
        1 -> {
            println("Fibonacci for $n:")
            lab7.fib(n)
        }
        2 -> {
            println("\nFactorial for $n is ${lab7.fact(n)}")
        }
        3 -> {
            println("\n$n has ${lab7.countDigits(abs(n))} digits")
        }
    }
}