fun countVowels(str: String): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var count = 0

    for (ch in str.lowercase()) {
        if (ch in vowels) {
            count++
        }
    }

    return count
}

fun main() {
    val s1 = "My name is Tarun"
    println("Number of vowels in '$s1': ${countVowels(s1)}")

    val s2 = "Kotlin"
    println("Number of vowels in '$s2': ${countVowels(s2)}")

    val s3 = "BCDFG"
    println("Number of vowels in '$s3': ${countVowels(s3)}")
}
