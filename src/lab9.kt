/**
 * This is a class Student that stores [Student]'s [firstName], [lastName], [university], [age]
 */
class Student(var firstName: String, var lastName: String) {
    private var university: String = "KPI"
    private var age: Int? = null

    /**
     * Method to return students Full Name
     *
     * Concatenates [firstName] and [lastName]
     * @return String
     */
    fun getFullName(): String {
        return "$firstName $lastName";
    }

    /**
     * Method to set private variable [age]
     */
    fun setAge(age: Int) {
        this.age = age
    }

    /**
     * Private method used in [toString] method to display [Student]'s age as [String]
     * @return String
     */
    private fun getAgeAsString(): String {
        if (age == null) {
            return "Age: unknown";
        }

        return "Age: $age"
    }

    /**
     * Override for default toString method
     * @return String
     */
    override fun toString(): String {
        return "{\nFirst name: $firstName,\nLast name: $lastName,\nUniversity: $university,\n${getAgeAsString()}\n}"
    }
}

class Group(var number: String, var students: MutableList<Student>) {
    fun addStudent(student: Student) {
        students.add(student)
    }

    fun removeStudent(student: Student) {
        students.remove(student)
    }

    override fun toString(): String {
        var result: String = "Group number $number with Students:"
        for (student in students) {
            result += "\n" + student.toString()
        }
        return result
    }
}


fun main() {
    val s1: Student = Student("test", "testovich")
    s1.setAge(15)
    val s2: Student = Student("s2", "fafs")
    val group: Group = Group("TB-91", mutableListOf(s1, s2))
    println(group.toString())
    group.removeStudent(s2)
    println("\n" + group.toString())
}