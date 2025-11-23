class BankAccount{
    private var balance = 0
    
    fun balanceAmount():Int
    {
        return balance
    }
    
    fun depositAmount(amount:Int){
        if (amount < 0)
        {
            println("Enter valid amount")
        }
        else
        {
            balance += amount
            println("Amount ${amount} Deposited Successfully!")
        }
    }
    
	fun withdrawFunds(amount:Int)
    {
        if (balance < 0)
        {
            println("No funds in the bank to withdraw!")
        }
        else if(amount > balance)
        {
            println("Insufficient Balance!")
        }
        else
        {
            balance -= amount
            println("Amount ${amount} witdraw Successful!")
        }
    }
}

fun main(){
    val acc = BankAccount()
	var choice:Int
    
    do {
        println("\n===== ATM MENU =====")
        println("1. Check Balance")
        println("2. Deposit Money")
        println("3. Withdraw Money")
        println("4. Exit")
        print("\nEnter your choice: ")
        
        choice = readLine()!!.toInt()
        
        when (choice)
        {
            1 -> {
                println("\nYour current Balance = ${acc.balanceAmount()}")
            }
            
            2 -> {
                print("\nEnter the amount to Deposit: ")
                val amt = readLine()!!.toInt()
                acc.depositAmount(amt)
            }
            
            3 -> {
                print("\nEnter the amount to Withdraw: ")
                val amt = readLine()!!.toInt()
                acc.withdrawFunds(amt)
            }
            
            4 -> println("\nThank you for using TK's ATM\n")
            
            else -> print("\nKindly enter the valid choice\n")
        } 
    } while(choice!=4)
}