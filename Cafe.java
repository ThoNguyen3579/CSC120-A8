/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* Constructor for the Cafe class */
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;

        System.out.println("You have built a cafe: ☕");
    }

    /* Overloaded constructor for the Cafe class with no address and floors*/
    public Cafe(String name, int coffee, int sugar, int cream, int cups){
        super(name, "Smith College", 1);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;

    }

    /**
     *  private method that restocks the ingredients whenever called 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /**
     * update the decrease in ingredients in inventory whenever coffee is sold.
     * if the cafe does not have enough ingredients, restock them
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1){
            this.restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -=nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Sucessfully sold our coffee!");
    }

    /* Overloaded sellCoffee method with only size, serving normal black coffee */
    public void sellCoffee(int size){
        if (this.nCoffeeOunces < size || this.nSugarPackets < 1 || this.nCreams < 1 || this.nCups < 1){
            this.restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        System.out.println("Sucessfully sold our coffee with overloaded method!");
    }

    /**
     * overrided method showing available options for Cafe
     */
    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(int size, int nSugarPackets, int nCreams)");
    }

    /**
   * overrided method allowing people to only stay on the first floor of the Cafe
   * @param n int
   */
    @Override
    public void goToFloor(int n){
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        } 
        if (n != 1){
            throw new RuntimeException(this.name + " only has the first floor accessible by customer");
        }
        System.out.println("You are already on the first floor of " + this.name);
    }    
}
