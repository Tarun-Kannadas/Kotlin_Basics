fun isPalindrome(str: String): Boolean 
{

    val cleaned = str.filter { it.isLetterOrDigit() }.lowercase()

    var left = 0
    var right = cleaned.length - 1

    while (left < right) {
        if (cleaned[left] != cleaned[right]) 
        {
            return false
        }
        left++
        right--
    }

    return true
}

fun main() {
    val s1 = "sos sos"
    println("Is '$s1' a palindrome? ${isPalindrome(s1)}")

    val s2 = "race a car"
    println("Is '$s2' a palindrome? ${isPalindrome(s2)}")

    val s3 = "Madam"
    println("Is '$s3' a palindrome? ${isPalindrome(s3)}")
}
