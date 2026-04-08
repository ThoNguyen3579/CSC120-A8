import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements{
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom; // boolean telling if this house have a dining room
  boolean hasElevator;


  /* Constructor for House class */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors); // let House class inherit attributes of Building class
    this.residents = new ArrayList<>(); // a list of residents in the house
    this.hasDiningRoom = hasDiningRoom; // boolean telling if this house have a dining room
    this.hasElevator =  hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /* Overloaded constructor for House class without the address, number of floors, and boolean hasDiningRoom*/
  public House(String name, int nFloors, boolean hasElevator) {
    super(name,"Smith College", nFloors); // let House class inherit attributes of Building class
    this.residents = new ArrayList<>(); // a list of residents in the house
    this.hasDiningRoom = false; // boolean automatically set to false, default house will not have a dining room
    System.out.println("You have built a house: 🏠");
  }

  /**
   * accessor for hasDiningRoom()
   * @return boolean showing if the house has a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * accessor for hasDiningRoom()
   * @return int showing the number of residents in the house
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * setter for the list of resident every time someone moves in
   */
  public void moveIn(Student s){
    if (!this.residents.contains(s)){
      this.residents.add(s);
    }else{ // throw exception if the student is already a resident 
      throw new RuntimeException("This student is already a resident");
    }
    }

  /**
   * setter for the list of resident every time someone moved out
   * @return Student who moved out
   */
  public Student moveOut(Student s){
    if (this.residents.contains(s)){
      this.residents.remove(s);
    } else{ // throw exception if the student is not a resident 
      throw new RuntimeException("This student is not a resident");
    }
    return s;
  }

  /**
   * check if a person is a resident of the house
   * @return boolean answering if a person is a resident of the house
   */
  public boolean isResident(Student s){
    boolean isResident = false;
    if(this.residents.contains(s)){
      System.out.println(s + " is a resident of the house");
      isResident = true;
    } else{
      throw new RuntimeException(s + " is NOT a resident of the house");
    }
    return isResident;
  }

  /**
  * overrided method showing available options for House
  */
  @Override
  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(Student s)\n + moveOut(Student s)");
  }

  /**
   * overrided method first checking if house has elevator,
   * if the house has elevator, allow people to move between non-adjacent floors
   * if the house does not have elevator, allow people to only go through floors of Cafe through staircase (consecutive floors)
   * @param n int
   */
  @Override
  public void goToFloor(int n){
    if (this.hasElevator == true){
      if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (n < 1 || n > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + n + " of " + this.name);
        this.activeFloor = n;
    } else{
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
          }
        if (n < 1 || n > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        else if(this.activeFloor - 1 == 0 || this.activeFloor + 1 == 0){
          this.activeFloor = n;
        }else{
          System.out.println(this.name + " has no elevator, so we cannot move between non-adjacent floors");
      }
    }
  }

  public static void main(String[] args) {
    Student thor = new Student("Thor", "haha", 2028);
    Student mimi = new Student("Mimi", "?", 2030);
    House emerson = new House("Emerson", "Paradise Road", 5, true, true);
    System.out.println(emerson.hasDiningRoom());
    emerson.moveIn(thor);
    System.out.println(emerson.nResidents());
    try {
      emerson.isResident(mimi);
            } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } 
  }

}