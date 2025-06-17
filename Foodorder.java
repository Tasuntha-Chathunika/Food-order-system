import java.util.Scanner;

abstract class Foodorder
{
	protected String foodname;
	protected double baseprice;
	protected int deliverytime;
	
	Foodorder(String foodname,double baseprice,int deliverytime)
	{
		this.foodname = foodname;
		this.baseprice = baseprice;
		this.deliverytime = deliverytime;
	}
	
	abstract void calculateTotalcost();
	abstract void getOrderdetails();
}

class Pizzaorder extends Foodorder
{
	private int extraTopping;
	
	Pizzaorder(String foodname,double baseprice,int deliverytime,int extraTopping)
	{
		super(foodname,baseprice,deliverytime);
		this.extraTopping = extraTopping;
	}
	
	public void getOrderdetails()
	{
		System.out.println("Ordered foodname: "+foodname);
		System.out.println("Baseprice: "+baseprice);
		System.out.println("Order Deliverytime in minutes: "+deliverytime);
	}
	
	public void calculateTotalcost()
	{
		int extracharge = 200;
		double finalprice = baseprice + (extraTopping*extracharge);
		System.out.println("Total cost of your Pizzaorder: "+finalprice);
	}
}

class Sandwitchorder extends Foodorder
{
	private int extrafilling;
	
	Sandwitchorder(String foodname,double baseprice,int deliverytime,int extrafilling)
	{
		super(foodname,baseprice,deliverytime);
		this.extrafilling = extrafilling;
	}
	public void getOrderdetails()
	{
		System.out.println("Ordered foodname: "+foodname);
		System.out.println("Baseprice: "+baseprice);
		System.out.println("Order Deliverytime in minutes: "+deliverytime);
	}
	
	public void calculateTotalcost()
	{
		int extracharge = 150;
		double finalprice = baseprice + (extrafilling*extracharge);
		System.out.println("Total cost of your Sandwitchorder: "+finalprice);
	}
}

class Saladorder extends Foodorder
{
	private String isLarge;
	
	Saladorder(String foodname,double baseprice,int deliverytime,String isLarge)
	{
		super(foodname,baseprice,deliverytime);
		this.isLarge = isLarge;
	}
	
	public void getOrderdetails()
	{
		System.out.println("Ordered foodname: "+foodname);
		System.out.println("Baseprice: "+baseprice);
		System.out.println("Order Deliverytime in minutes: "+deliverytime);
	}
	
	public void calculateTotalcost()
	{
		if(isLarge.equals("large"))
		{
			double finalprice = baseprice - (baseprice*0.1);
			System.out.println("Total cost of your Saladorder: "+finalprice);
		}
		else if(isLarge.equals("small"))
		{
			System.out.println("Total cost of your Saladorder: "+baseprice);
		}
		else{
			System.out.println("Invalid input ");
		}
	}
}

class Fooddelivery
{
	public static void main(String args[])
	{
	Scanner scan = new Scanner(System.in);
	System.out.print("Type of the food you want to order: ");
	String foodname = scan.nextLine();
	
	
	switch(foodname)
	{
		case "Pizza":
			System.out.print("Enter number of extraTopping in pizza: ");
			int extraTopping = scan.nextInt();
			Pizzaorder pizza = new Pizzaorder(foodname,1200,12,extraTopping);
			System.out.println("Details of your order");
			pizza.getOrderdetails();
			pizza.calculateTotalcost();
			break;
			
		case "Sandwitch":
			System.out.print("Enter number of extrafilling in pizza: ");
			int extrafilling = scan.nextInt();
			Sandwitchorder sand = new Sandwitchorder(foodname,600,20,extrafilling);
			System.out.println("Details of your order");
			sand.getOrderdetails();
			sand.calculateTotalcost();
			break;
		
		case "Salad":
			System.out.print("Is you want your salad portion large or small: ");
			String isLarge = scan.nextLine();
			Saladorder salad = new Saladorder(foodname,500,50,isLarge);
			System.out.println("Details of your order");
			salad.getOrderdetails();
			salad.calculateTotalcost();
			break;
			
		default:
			System.out.println("Invalid entry");
			break;
			
	}
	}
	
	
}