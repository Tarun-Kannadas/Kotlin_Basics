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

fun main(args:Array<String>)
{
    val shop_cart = ShoppingCart()
    
    if (args.isEmpty())
    {
        println("No products passed as arguments.")
        println("Example:")
        println("Apple,50,2 Orange,30,5 Milk,25,1")
        return
    }
    
    println("___ Shopping Cart (Program Arguments Mode) ___")
    println("Press 'X' to stop adding products and exit\n")
    
	for(arg in args)
    {
        if (arg == "X")
        {
            println("Exiting Cart...")
            break
        }
        
        val parts = arg.split(",")
        if (parts.size == 3)
        {
            val name = parts[0]
            val price = parts[1].toDouble()
            val qty = parts[2].toInt()
            
            val prdct = Product(name, price, qty)
            shop_cart.addProducts(prdct)
        }
        else
        {
            println("Invalid argument format: $arg")
        }
    }
    
    shop_cart.showCart()
    
    val total = shop_cart.calculateTotal()
    println("\nTotal cost = Rs.${total}")
   	println("\nThank you for Shopping!")
}