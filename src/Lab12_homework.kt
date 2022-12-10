import kotlin.math.abs

class Lab12Homework {
    fun countWords(s: String): Int {
        var result = 0
        for (word in s.split(' ')) {
            if (word.matches(Regex("(,|\\.|\\d){${word.length}}")) && word.contains(Regex("\\d"))) {
                continue
            }
            result++
        }
        return result
    }

    fun countNumbers(s: String): Int {
        var result = 0
        for (word in s.split(' ')) {
            if (word.matches(Regex("(\\d)+(\\.|,)?(\\d)*"))) {
                result++
            }
        }
        return result
    }

    fun getOnlyLetters(s: String): String {
        val re = Regex("[^a-zA-Z]")
        return re.replace(s, "")
    }

    fun removeMultipleSpaces(s: String): String {
        val re = Regex("\\s+")
        return re.replace(s, " ")
    }

    fun onlyCaptialLetterFirst(s: String): String? {
        var result: String? = null;
        for (word in s.split(" ")) {
            if (word.matches(Regex("[A-Z].*"))) {
                if (result == null) {
                    result = word
                } else {
                    result += " $word"
                }
            }
        }
        return result;
    }
}

fun main() {
    print("Enter string: ")
    val s = readLine().toString()
    val lab12 = Lab12Homework()

    var taskNumber:Int
    do {
        print(
            "\n1 - count words" +
            "\n2 - count numbers" +
            "\n3 - only letters" +
            "\n4 - no multiple spaces" +
            "\n5 - only first capital letter" +
            "nEnter your choice: "
        )
        taskNumber = readLine()!!.toInt()
    } while (taskNumber < 1 || taskNumber > 5)

    print("Result: ")
    when (taskNumber) {
        1 -> println(lab12.countWords(s))
        2 -> println(lab12.countNumbers(s))
        3 -> println(lab12.getOnlyLetters(s))
        4 -> println(lab12.removeMultipleSpaces(s))
        5 -> println(lab12.onlyCaptialLetterFirst(s))
    }
}