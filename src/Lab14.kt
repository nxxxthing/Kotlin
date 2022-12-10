import java.io.File
import java.util.*

class Lab14 {
    fun replaceSubstring() {
        print("Enter file name (must be in folder files): ")
        val fileName = readLine().toString()
        val file = File("files/$fileName")
        if (! file.exists()) {
            println("File $fileName does not exists in folder files!")
            return
        }

        print("Enter substring you want to replace: ")
        val substring = readLine().toString()

        print("Enter string you want to write: ")
        val newString = readLine().toString()

        var text = file.readText()

        text = text.replace(substring, newString)
        file.writeText(text)
        println("Success!")
    }

    fun copyContents() {
        print("Enter file name to copy form (must be in folder files): ")
        var fileName: String = readLine().toString()
        var file = File("files/$fileName")
        if (! file.exists()) {
            println("File $fileName does not exists in folder files!")
            return
        }

        val text = file.readText()

        file = createFile(extension = ".bak") ?: return

        file.writeText(text)
        println("Success!")
    }

    fun oddAndEvenLines() {
        print("Enter file name to copy form (must be in folder files): ")
        val fileName: String = readLine().toString()
        val file = File("files/$fileName")
        if (! file.exists()) {
            println("File $fileName does not exists in folder files!")
            return
        }

        val oddFile = createFile("Enter file name to create (for odd lines): ") ?: return
        val evenFile = createFile("Enter file name to create (for even lines): ") ?: return

        var isOdd = 1;
        file.forEachLine {
            if (isOdd == 1) {
                oddFile.appendText("$it\n")
            } else {
                evenFile.appendText("$it\n")
            }
            isOdd = 1 - isOdd
        }

        println("Success!")
    }

    fun cipherFile() {
        print("Enter file name to cipher (must be in folder files): ")
        val fileName = readLine().toString()
        val file = File("files/$fileName")
        if (! file.exists()) {
            println("File $fileName does not exists in folder files!")
            return
        } else if (! file.canWrite()) {
            println("File $fileName was already ciphered")
            return
        }

        print("Enter number to cipher with: ")
        val n = readLine()!!.toInt()

        file.writeText(cipherText(file, n))
        file.setReadOnly()
        println("Success!")
    }

    fun decipherFile() {
        print("Enter file name to decipher (must be in folder files): ")
        val fileName = readLine().toString()
        val file = File("files/$fileName")
        if (! file.exists()) {
            println("File $fileName does not exists in folder files!")
            return
        } else if (file.canWrite()) {
            println("File $fileName was not ciphered")
            return
        }

        file.setWritable(true)

        print("Enter number it was ciphered with: ")
        val n = readLine()!!.toInt()


        file.writeText(cipherText(file, -n))
        println("Success!")
    }

    private fun cipherText(file: File, n: Int): String {
        var result: String = ""
        file.readText().forEach {
            result += Char(it.code + n)
        }
        return result
    }

    private fun createFile(message: String = "Enter file name to create: ", extension: String = ""): File? {
        print(message)
        val fileName = readLine().toString()
        val file = File("files/$fileName$extension")
        if (file.exists()) {
            println("File $fileName already exists, do you want to rewrite it? (Y/N)")
            var answer: String
            do {
                answer = readLine().toString()
                answer = answer.lowercase()
            } while (answer != "y" && answer != "n")

            if (answer == "n") {
                return null
            }
        }
        file.setWritable(true)
        file.writeText("")
        return file
    }
}

fun main() {
    val lab14 = Lab14()
    var taskNumber:Int
    do {
        print(
            "\n1 - Replace substring" +
            "\n2 - Copy file contents" +
            "\n3 - Odd and Even lines" +
            "\n4 - Cypher file" +
            "\n5 - Decipher file" +
            "\nEnter your choice: "
        )
        taskNumber = readLine()!!.toInt()
    } while (taskNumber < 1 || taskNumber > 5)

    when (taskNumber) {
        1 -> lab14.replaceSubstring()
        2 -> lab14.copyContents()
        3 -> lab14.oddAndEvenLines()
        4 -> lab14.cipherFile()
        5 -> lab14.decipherFile()
    }
}