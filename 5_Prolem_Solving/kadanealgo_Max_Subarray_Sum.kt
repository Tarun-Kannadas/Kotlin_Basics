fun maxSubArraySum(arr: IntArray): Int {
    if (arr.isEmpty()) return 0

    var currentSum = arr[0]
    var maxSum = arr[0]

    for (i in 1 until arr.size)
    {
        currentSum = maxOf(arr[i], currentSum + arr[i])
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}

fun main() 
{
    val arr1 = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println("Maximum Subarray Sum in arr1: ${maxSubArraySum(arr1)}")

    val arr2 = intArrayOf(0,1,2,-1,3)
    println("Maximum Subarray Sum in arr2: ${maxSubArraySum(arr2)}")

    val arr3 = intArrayOf(5,4,-1,7,8)
    println("Maximum Subarray Sum in arr3: ${maxSubArraySum(arr3)}")
}