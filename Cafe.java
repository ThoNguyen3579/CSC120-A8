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
    }

    /* Overloaded sellCoffee method with only size, serving normal black coffee */
    public void sellCoffee(int size){
        if (this.nCoffeeOunces < size || this.nSugarPackets < 1 || this.nCreams < 1 || this.nCups < 1){
            this.restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
    }

    /**
     * overrided method showing available options for Cafe
     */
    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(int size, int nSugarPackets, int nCreams)");
    }

    /**
   * overrided method allowing people to only go through floors of Cafe through staircase (consecutive floors)
   * @param n int
   */
    @Override
    public void goToFloor(int n){
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
          }
        if (n < 1 || n > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        else if(this.activeFloor - 1== n || this.activeFloor + 1 == n){
          this.activeFloor = n;
        }else{
          System.out.println("No elevator, so we cannot move between non-adjacent floors");
      }
    }    

    public static void main(String[] args) {
        Cafe cc = new Cafe("CC", "Smith College", 1, 5, 10, 10, 5);
        cc.sellCoffee(3, 11, 2);
    }
    
}
