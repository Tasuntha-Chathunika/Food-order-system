import java.util.Scanner;

abstract class Foodorder {
    protected String foodname;
    protected double baseprice;
    protected int deliverytime;

    Foodorder(String foodname, double baseprice, int deliverytime) {
        this.foodname = foodname;
        this.baseprice = baseprice;
        this.deliverytime = deliverytime;
    }

    abstract void calculateTotalcost();
    abstract void getOrderdetails();
}

class Pizzaorder extends Foodorder {
    private int extraTopping;

    Pizzaorder(String foodname, double baseprice, int deliverytime, int extraTopping) {
        super(foodname, baseprice, deliverytime);
        this.extraTopping = extraTopping;
    }

    public void getOrderdetails() {
        System.out.println("Ordered food: " + foodname);
        System.out.println("Base price: Rs." + baseprice);
        System.out.println("Delivery time: " + deliverytime + " minutes");
    }

    public void calculateTotalcost() {
        int extracharge = 200;
        double finalprice = baseprice + (extraTopping * extracharge);
        System.out.println("Total cost of your Pizza: Rs." + finalprice);
    }
}

class Sandwitchorder extends Foodorder {
    private int extrafilling;

    Sandwitchorder(String foodname, double baseprice, int deliverytime, int extrafilling) {
        super(foodname, baseprice, deliverytime);
        this.extrafilling = extrafilling;
    }

    public void getOrderdetails() {
        System.out.println("Ordered food: " + foodname);
        System.out.println("Base price: Rs." + baseprice);
        System.out.println("Delivery time: " + deliverytime + " minutes");
    }

    public void calculateTotalcost() {
        int extracharge = 150;
        double finalprice = baseprice + (extrafilling * extracharge);
        System.out.println("Total cost of your Sandwich: Rs." + finalprice);
    }
}

class Saladorder extends Foodorder {
    private String isLarge;

    Saladorder(String foodname, double baseprice, int deliverytime, String isLarge) {
        super(foodname, baseprice, deliverytime);
        this.isLarge = isLarge;
    }

    public void getOrderdetails() {
        System.out.println("Ordered food: " + foodname);
        System.out.println("Base price: Rs." + baseprice);
        System.out.println("Delivery time: " + deliverytime + " minutes");
    }

    public void calculateTotalcost() {
        if (isLarge.equalsIgnoreCase("large")) {
            double finalprice = baseprice - (baseprice * 0.1);
            System.out.println("Total cost of your Large Salad: Rs." + finalprice);
        } else if (isLarge.equalsIgnoreCase("small")) {
            System.out.println("Total cost of your Small Salad: Rs." + baseprice);
        } else {
            System.out.println("Invalid size entered for Salad.");
        }
    }
}

public class Fooddelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the food you want to order (Pizza / Sandwitch / Salad): ");
        String foodname = scan.nextLine();

        switch (foodname) {
            case "Pizza":
                System.out.print("Enter number of extra toppings: ");
                int extraTopping = scan.nextInt();
                Pizzaorder pizza = new Pizzaorder(foodname, 1200, 12, extraTopping);
                System.out.println("\n--- Order Details ---");
                pizza.getOrderdetails();
                pizza.calculateTotalcost();
                break;

            case "Sandwitch":
                System.out.print("Enter number of extra fillings: ");
                int extrafilling = scan.nextInt();
                Sandwitchorder sand = new Sandwitchorder(foodname, 600, 20, extrafilling);
                System.out.println("\n--- Order Details ---");
                sand.getOrderdetails();
                sand.calculateTotalcost();
                break;

            case "Salad":
                System.out.print("Do you want your Salad large or small? ");
                String size = scan.nextLine(); // fix: use extra scan for newline
                size = scan.nextLine();        // correct the newline bug
                Saladorder salad = new Saladorder(foodname, 500, 15, size);
                System.out.println("\n--- Order Details ---");
                salad.getOrderdetails();
                salad.calculateTotalcost();
                break;

            default:
                System.out.println("Invalid food choice. Please select Pizza, Sandwitch or Salad.");
        }

        scan.close();
    }
}
