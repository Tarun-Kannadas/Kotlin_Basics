fun findMissingNumber(arr: IntArray): Int 
{
    //Works only if the array starts from 1
    // val n = arr.size + 1 val expectedSum = n.toLong()*(n + 1)/2
    // val actualSum = arr.sum() var actualSum = 0L 
    // for (n in arr) 
    // { 
    //     actualSum += n.toLong() 
    // } 
    // return (expectedSum - actualSum).toInt()

    //Another way to calculate expected sum depending on whether the array starts from 0 or 1
    val n = arr.size + 1
    val minVal = arr.minOrNull() ?: 0

    val expectedSum = if (minVal == 0)
        (n - 1) * n / 2
    else
        n * (n + 1) / 2

    var actualSum = 0L
    for (num in arr) {
        actualSum += num
    }

    return (expectedSum - actualSum).toInt()
}

fun main()
{
    val arr1 = intArrayOf(1, 2, 4, 5, 6)
    println("Missing number in arr1: ${findMissingNumber(arr1)}")
    val arr2 = intArrayOf(0, 1, 3, 4, 5)
    println("Missing number in arr2: ${findMissingNumber(arr2)}")
    val arr3 = intArrayOf(1)
    println("Missing number in arr3: ${findMissingNumber(arr3)}")
}