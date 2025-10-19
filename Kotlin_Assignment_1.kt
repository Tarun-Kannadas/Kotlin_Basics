// Interface segregation & abstraction
interface Payable {
    fun calculatePay(): Double
}

// Another small interface for reporting
interface Reportable {
    fun generateReport(): String
}

// Base class demonstrating encapsulation
open class Employee(
    private val name: String,
    private val baseSalary: Double
) : Payable, Reportable {

    // Getter methods (Encapsulation)
    fun getName() = name
    fun getBaseSalary() = baseSalary

    // Polymorphic method
    override fun calculatePay(): Double {
        return baseSalary
    }

    // Default report
    override fun generateReport(): String {
        return "Employee: $name, Salary: $baseSalary"
    }
}

// Subclass demonstrating inheritance & polymorphism
class Manager(
    name: String,
    baseSalary: Double,
    private val bonus: Double
) : Employee(name, baseSalary) {

    override fun calculatePay(): Double {
        return getBaseSalary() + bonus
    }

    override fun generateReport(): String {
        return "Manager: ${getName()}, Total Salary: ${calculatePay()}"
    }
}

// Another subclass
class Developer(
    name: String,
    baseSalary: Double,
    private val projectAllowance: Double
) : Employee(name, baseSalary) {

    override fun calculatePay(): Double {
        return getBaseSalary() + projectAllowance
    }

    override fun generateReport(): String {
        return "Developer: ${getName()}, Total Salary: ${calculatePay()}"
    }
}

// Single Responsibility Principle - salary calculator is separate
class SalaryProcessor {
    fun processPayment(employee: Payable) {
        println("Processing salary: ${employee.calculatePay()}")
    }
}

// Dependency Inversion: high-level class depends on abstraction (Payable)
class PayrollSystem(private val employees: List<Payable>) {
    fun processAll() {
        for (emp in employees) {
            println("Paying employee: ${emp.calculatePay()}")
        }
    }
}

// Demonstration with exception handling
fun main() {
    try {
        val manager = Manager("Alice", 50000.0, 10000.0)
        val developer = Developer("Bob", 40000.0, 8000.0)

        val salaryProcessor = SalaryProcessor()
        salaryProcessor.processPayment(manager)
        salaryProcessor.processPayment(developer)

        val payrollSystem = PayrollSystem(listOf(manager, developer))
        payrollSystem.processAll()

        println(manager.generateReport())
        println(developer.generateReport())

        // Example of exception handling
        val invalidSalary = -1000.0
        if (invalidSalary < 0) throw IllegalArgumentException("Salary cannot be negative!")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
