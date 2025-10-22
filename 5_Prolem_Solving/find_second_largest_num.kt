fun secondLargest(arr: IntArray): Int {
    if (arr.size < 2) return -1

    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE

    for (num in arr) 
    {
        if (num > largest) 
        {
            secondLargest = largest
            largest = num
        } 
        else if (num > secondLargest && num != largest) 
        {

            secondLargest = num
        }
    }

    return if (secondLargest == Int.MIN_VALUE) -1 else secondLargest
}

fun main() {
    val arr1 = intArrayOf(12, 35, 1, 10, 34, 1)
    println("Second largest element: ${secondLargest(arr1)}") // 34

    val arr2 = intArrayOf(10, 10, 10)
    println("Second largest element: ${secondLargest(arr2)}") // -1

    val arr3 = intArrayOf(5)
    println("Second largest element: ${secondLargest(arr3)}") // -1
}
