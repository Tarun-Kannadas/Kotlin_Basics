data class Book (var title: String, var author:String, var price:Double, var category:String, var isAvailable:Boolean = true)

open class Member (var name:String, var memberId:Int)
{
  val borrowedBooks = mutableListOf<Book>()
  open val limit = 0
  
  open fun borrowBook(book:Book, library:Library){}
  
  fun showAllBorrowedBooks(library:Library)
  {
    if (borrowedBooks.isEmpty())
    {
      println("\nNo Borrowed Books!")
    }
    else
    {
      println("\n----- Borrowed Books -----")
      for (b in borrowedBooks)
      {
        println("Title: ${b.title} | Author: ${b.author} | Price: ${b.price} | Category: ${b.category}")
      } 
    }
  }
}

class StudentMember(name: String, memberId:Int, var grade:String):Member(name, memberId)
{
  override val limit = 3
  
  override fun borrowBook(book:Book, library:Library)
  {
    if(borrowedBooks.size >= limit)
    {
      println("\nStudents can borrow only $limit books")
      return
    }

    if(book !in library.books)
    {
      println("\nBook not found in library")
    }
    
    if (!book.isAvailable)
    {
      println("This book is already Borrowed")
      return
    }
    
    borrowedBooks.add(book)
    book.isAvailable = false
    println("\n${book.title} added Successfully!")
  }
}

class TeacherMember(name:String, memberId:Int):Member(name,memberId)
{
  override val limit = 5

  override fun borrowBook(book:Book, library:Library)
  {
    if(borrowedBooks.size >= limit)
    {
      println("\nTeachers can borrow only $limit books")
      return
    }

    if(book !in library.books)
    {
      println("\nBook not found in library")
    }
    
    if (!book.isAvailable)
    {
      println("This book is already Borrowed")
      return
    }
    
    borrowedBooks.add(book)
    book.isAvailable = false
    println("\n${book.title} added Successfully!")
  }
}

class Library
{
  var books = mutableListOf<Book>()
  
  fun addBook(book:Book)
  {
    books.add(book)
    println("Book added Successfully!")
  }
  
  fun searchByCategory(category:String)
  {
    val results = books.filter {it.category == category}
    
    if (results.isEmpty())
    {
      println("\nNo books found in this category!")
    }
    else
    {
      println("\nBooks in $category category:")
      for (b in results)
      {
        println("Title: ${b.title} by ${b.author}")
      }
    }
  }
  
  fun showAllBooks()
  {
    if (books.isEmpty())
    {
      println("\nNo Books Available!")
    }
    else
    {
      println("\n----- ALL BOOKS IN LIBRARY -----")
      for (b in books)
      {
        println("Title: ${b.title} | Author: ${b.author} | Price: ${b.price} | Category: ${b.category}")
      } 
    }
  }
}

fun main()
{
  val library = Library()
  
  val b1 = Book("Kotlin Basics", "JetBrains", 499.0, "Programming")
  val b2 = Book("OOP Concepts", "Grady Booch", 599.0, "Computer Science")
  val b3 = Book("Physics Fundamentals", "HC Verma", 699.0, "Science")
  val b4 = Book("Data Structures", "Narasimha Karumanchi", 799.0, "Programming")

  library.addBook(b1)
  library.addBook(b2)
  library.addBook(b3)
  library.addBook(b4)
  
  library.showAllBooks()
  
  val student = StudentMember("Tarun", 101, "MVoc Degree")
  val teacher = TeacherMember("Michael", 201)
  
  println("\n--- Student Trying to Borrow Books ---")

  student.borrowBook(b1, library)  
  student.borrowBook(b1, library)   
  student.borrowBook(b2, library)  
  student.borrowBook(b3, library)   
  student.borrowBook(b4, library)  

  println("\n--- Teacher Trying to Borrow Books ---")

  teacher.borrowBook(b4, library) 
  teacher.borrowBook(b1, library)  

  println("\n--- Final Book Status ---")
  library.showAllBooks()

  println("\n--- Student Borrowed Books ---")
  student.showAllBorrowedBooks(library)

  println("\n--- Teacher Borrowed Books ---")
  teacher.showAllBorrowedBooks(library)
  library.searchByCategory("Programming")
}