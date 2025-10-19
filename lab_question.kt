import java.time.LocalDate

open class person(open var name:String)

data class student(override var name:String,var rollNumber:Int):person(name)

data class attendanceRecord(val student:student, val date:String, val status:Boolean = false)
{
    fun getStatus():String
    {
        return if (status == true) "Present" else "Absent"
    }
}

class attendanceMarker
{

    fun markAttendance(record:attendanceRecord):attendanceRecord
    {
        return record
    }

    fun markAttendance(student:student,date:String,status:Boolean):attendanceRecord
    {
        return attendanceRecord(student,date,status)
    }

    fun show(record:attendanceRecord,action:(attendanceRecord)->Unit)
    {
        return action(record)
    }
}

fun main()
{    
    val today = LocalDate.now().toString()
    val marker = attendanceMarker()

    val student1 = student("Tarun",112)
    val record = marker.markAttendance(student1,today,true)

    val student2 = student("Ashin",105)
    val record2 = marker.markAttendance(student2,today,false)

    println("Name: ${record.student.name}")
    println("Roll Number: ${record.student.rollNumber}")
    println("Date: ${record.date}")
    println("status: ${record.getStatus()}")

    println("\nName: ${record2.student.name}")
    println("Roll Number: ${record2.student.rollNumber}")
    println("Date: ${record2.date}")
    println("status: ${record2.getStatus()}")
}