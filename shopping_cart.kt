data class Product(var name:String, var price:Double,var quantity:Int)

class ShoppingCart{
    private val products = mutableListOf<Product>()
    
    fun addProducts(product:Product){
        products.add(product)
        println("Product Added Successfully\n")
    }
    
    fun calculateTotal():Double{
        var total = 0.0
        for(p in products)
        {
            total = total + (p.price*p.quantity)
        }
        return total
    }
    
    fun showCart(){
        println("\n_______Cart Items_______")
        if (products.isEmpty())
        {
            println("\nCart is Empty")
        }
        else
        {
            for(p in products)
            {
                println("Name: ${p.name} | Price: ${p.price} | Quantity: ${p.quantity}")
            }
        }
    }
}

fun main()
{
    val shop_cart = ShoppingCart()
    var ch_name:String
    
    println("____Shopping Cart Application____")
    println("Press 'X' to stop adding products and exit\n")
    
    do{
      print("Enter product name (or X to stop): ")
      ch_name = readLine()!!.trim()
      
      if (ch_name == "X") break
        
      print("\nEnter product price: ")
      val price = readLine()!!.toDouble()
      
      print("\nEnter product quantity: ")
      val qty = readLine()!!.toInt()
      
      val prdct = Product(ch_name, price, qty)
      shop_cart.addProducts(prdct)
      
    } while(true)
    
    shop_cart.showCart()
    
    val total = shop_cart.calculateTotal()
    println("\nTotal cost = Rs.${total}")
   	println("\nThank you for Shopping!")
}

// Alternative Way using when() like a switch case
// data class Product(var name:String, var price:Double,var quantity:Int)

// class ShoppingCart{
//     private val products = mutableListOf<Product>()
    
//     fun addProducts(product:Product){
//         products.add(product)
//         println("Product Added Successfully\n")
//     }
    
//     fun calculateTotal():Double{
//         var total = 0.0
//         for(p in products)
//         {
//             total = total + (p.price*p.quantity)
//         }
//         return total
//     }
    
//     fun showCart(){
//         println("\n_______Cart Items_______")
//         if (products.isEmpty())
//         {
//             println("\nCart is Empty")
//         }
//         else
//         {
//             for(p in products)
//             {
//                 println("Name: ${p.name} | Price: ${p.price} | Quantity: ${p.quantity}")
//             }
//         }
//     }
// }

// fun main()
// {
//     val shop_cart = ShoppingCart()
//     var choice:Int
    
//     do {
      
//       println("____Shopping Cart Application____")
//       println("Enter '1' to Add a product\n")
//       println("Enter '2' to exit the Cart\n")
      
//       choice = readLine()!!.toInt()
      
//       when(choice)
//       {
//         1 -> {
//         print("Enter Product Name: ")
//         var name = readLine()!!
        
//         print("Enter Product Price: ")
//         var price = readLine()!!.toDouble()
        
//         print("Enter Product Quantity: ")
//         var qty = readLine()!!.toInt()
        
//         var prdct = Product(name, price, qty)
//         shop_cart.addProducts(prdct)
//         println("Product added Successfully!\n")
//         }
        
//         2 -> {
//           println("Exiting the Cart...")
//         }
        
//         else -> println("Error, Enter valid option!")

//       }
      
//     } while(choice != 2)
    
//     shop_cart.showCart()
    
//     val total = shop_cart.calculateTotal()
//     println("\nTotal cost = Rs.${total}")
//    	println("\nThank you for Shopping!")
// }