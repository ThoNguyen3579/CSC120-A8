import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        try {

        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);

        Building sabinreed = new Building("Sabin Reed", "Smith College", 3);
        myMap.addBuilding(sabinreed);
        sabinreed.enter();
        sabinreed.goToFloor(3);

        System.out.println("\n \n ------- Library Time! --------");
        Library hillyer = new Library("Hillyer Library","Smith College", 2);
        Library neilson = new Library("Neilson Library", "Smith College", 5);
        Library myLibrary = new Library("Nice Library");
        myMap.addBuilding(hillyer);
        myMap.addBuilding(neilson);
        myMap.addBuilding(myLibrary);
        neilson.addTitle("Price and Prejudice");
        neilson.enter();
        neilson.goToFloor(4);
        neilson.showOptions();

        System.out.println("\n \n ------- House Time! --------");
        House emerson = new House("Emerson House", 5, false);
        House king = new House("King House", "Smith College", 3,true, true);      
        House chapin = new House("Chapin","Smith College", 4, true, true);  
        Student mimi = new Student("Mimi", "ggffdsdg", 2029);
        Student momo = new Student("Momo", "kfnks", 2029);
        myMap.addBuilding(emerson);
        myMap.addBuilding(king);
        myMap.addBuilding(chapin);
        emerson.enter();
        emerson.goToFloor(3);
        emerson.moveIn(mimi, momo);
        emerson.isResident(mimi);
        emerson.isResident(momo);
        king.enter();
        king.goToFloor(3);
        chapin.enter();
        chapin.goUp();
        chapin.goToFloor(3);
        emerson.showOptions();

        System.out.println("\n \n ------- Cafe Time! --------");
        Cafe cc = new Cafe("CC", "Smith College", 1, 5, 10, 10, 5);
        Cafe compass = new Cafe("Compass Cafe", 5, 10, 10, 5);
        Cafe myCafe = new Cafe("Cat Cafe", 5, 10, 10, 5);
        System.out.println(cc);
        myMap.addBuilding(cc);
        myMap.addBuilding(compass);
        myMap.addBuilding(myCafe);
        cc.sellCoffee(3, 11, 2);
        compass.sellCoffee(4);
        cc.showOptions();
        myCafe.enter();
        myCafe.sellCoffee(5);
        System.out.println(myMap);
        compass.goToFloor(3);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());;
        }

    }

    
}
