open class Employee {
    // Public — accessible from anywhere
    public var name: String = "Rahul"

    // Private — accessible only inside this class
    private var salary: Int = 30000

    // Protected — accessible inside this class AND its subclasses
    protected var bonus: Int = 5000

    // Internal — accessible anywhere within the same module/project
    internal var department: String = "IT"

    fun showDetails() {
        println("\nName: $name")          // ✅ allowed
        println("Salary: $salary")      // ✅ allowed
        println("Bonus: $bonus")        // ✅ allowed
        println("Department: $department") // ✅ allowed
    }
}

class Manager : Employee() {
    fun showManagerData() {
        println("\nName: $name")       // ✅ public — accessible
        println("Salary: private - not accessible") // ❌ private — not accessible
        println("Bonus: $bonus")     // ✅ protected — accessible in subclass
        println("Department: $department") // ✅ internal — same module
    }
}

fun main() {
    val emp = Employee()
    emp.showDetails()        // ✅ allowed (public function)
    
    println("\n${emp.name}")           // ✅ public
    // println(emp.salary)      // ❌ private — cannot access outside
    // println(emp.bonus)       // ❌ protected — cannot access outside
    println(emp.department)     // ✅ internal — same module

    val mgr = Manager()
    mgr.showManagerData()       // ✅ works fine
}
