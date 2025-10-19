open class employee(open var name:String="",open var salary:Int=0,open var bonus:Int=0)
{
    open fun calculateBonus():Int = bonus

    open fun calculateReview():String = if (salary>30000) "Excellent" else "Good"

    open fun empDescription() = "Name: $name \nSalary: $salary \nBonus: ${calculateBonus()}"
}

data class manager(override var name:String, override var salary:Int, override var bonus:Int, var review:String):employee(name,salary,bonus)
{
    override fun calculateReview():String = if (salary>30000) "Excellent" else "Good"

    override fun calculateBonus(): Int
    {
        return (bonus*1.2).toInt()
    }

    override fun empDescription() = "Manager Name: $name \nSalary: $salary \nBonus: ${calculateBonus()} \nPerformance Review: ${calculateReview()}"
}

data class developer(override var name:String, override var salary:Int, override var bonus:Int, var review:String):employee(name,salary,bonus)
{
    override fun calculateReview():String = if (salary>30000) "Excellent" else "Good"

    override fun calculateBonus(): Int
    {
        return (bonus*1.1).toInt()
    }

    override fun empDescription() = "Developer Name: $name \nSalary: $salary \nBonus: ${calculateBonus()} \nPerformance Review: ${calculateReview()}"
}

class empManager
{
    private val empList = mutableListOf<employee>()

    fun addEmp(manager:manager):manager
    {
        empList.add(manager)
        return manager
    }

    fun addEmp(developer:developer):developer
    {
        empList.add(developer)
        return developer
    }

    fun showEmp(employee:employee,action:(employee)->Unit)
    {
        action(employee)
    }

    fun displayAllEmployee()
    {
        println("\nEmployee List")
        
        for (e in empList)
        {
            println(e.empDescription())
            println("................")
        }
    }
}

fun main()
{
    val manager1 = manager("Rahul",25000,10000,"")

    val developer2 = developer("Manohar",35000,15000,"")

    val emp = empManager()

    val managerDetail = emp.addEmp(manager1)
    val developerDetail = emp.addEmp(developer2)

    emp.showEmp(managerDetail){
        println("\nManager Details:\n${it.empDescription()}")
    }

    println()

    println("\n Developer Details: \n${developerDetail.empDescription()}")

    emp.displayAllEmployee()
}