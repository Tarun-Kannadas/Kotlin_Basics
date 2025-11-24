// Question
// You are given an array consisting of positive and negative numbers. You are required to partition the array into subarray based on the index of negative numbers. Print the sum of the subarray and display the highest sub array as showing in the sample output: Input Arr = {1,2,3,-4,4,1} Ouput "The sub arrays and their sum are: " [1,2,3] -> 6 [4,1] -> 5 The highest sub array is [1,2,3]
// My idea of Solving it was to find negative number through a for loop and add the numbers to the left in l_arr and right to r_arr then do the adding of l_arr and r_arr using for loop then compare the result of the l_arr and r_arr like the size and determine the highest array out the both.

fun main()
{
    var arr = arrayOf(1,2,3,-4,4,1)
    var l_arr = arrayOf<Int>()
    var r_arr = arrayOf<Int>()

    var foundNegative = false

    for (num in arr)
    {
        if (num < 0)
        {
            foundNegative = true
        }
        else
        {
            if(!foundNegative)
            {
                l_arr = l_arr.plus(num)
            }
            else
            {
                r_arr = r_arr.plus(num)
            }
        }
    }

    val leftSum = l_arr.sum()
    val rightSum = r_arr.sum()

    println("The sub arrays and their sum are: ")
    println("${l_arr.toList()} -> Sum = $leftSum")
    println("${r_arr.toList()} -> Sum = $rightSum")

    if (leftSum > rightSum) 
    {
        println("Highest subarray is: ${l_arr.toList()}")
    } 
    else 
    {
        println("Highest subarray is: ${r_arr.toList()}")
    }
}