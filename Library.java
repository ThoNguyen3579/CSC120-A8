/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Set;

public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;

    /* Constructor for Library class */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); // let Library class inherit attributes of Building class
      this.collection = new Hashtable<>();
      System.out.println("You have built a library: 📖. This library is called " + this.name);
    }
    
    /**
     * add the title if the library does not have it, throw exception otherwise
     * @param title a string that is the title of the book
     */
    public void addTitle(String title){
      System.out.println("Adding book ...");
     if (!collection.containsKey(title)){
        collection.put(title, true);
        System.out.println("The book " + title + " is sucessfully added to the library's collection.");
     } else {
      throw new RuntimeException(title + " is already in library");
     }
    }
  
    /**
     * remove the title if it is the library, throw exception otherwise
     * @param title a string that is the title of the book
     * @return the title being removed
     */
    public String removeTitle(String title){
     if (collection.containsKey(title)){
        collection.remove(title);
     } else {
      throw new RuntimeException(title + " is NOT in library");
     }
     return title;
    }

    /**
     * check the book out of the library by turning value in the (title, boolean) pair into false if the book is currently available,
     * throw exception otherwise
     * @param title a String that is the title of the book being checked out
     */
    public void checkOut(String title){
      if (this.collection.get(title).equals(true)){
        this.collection.put(title, false);
      } else{
        throw new RuntimeException(title + "has been checked out/not existing");
      }
    }

    /**
     * return the book back to the library by turning value in the (title, boolean) pair into true if the book is currently checked out,
     * throw exception otherwise
     * @param title a String that is the title of the book being returned
     */
    public void returnBook(String title){
      if (this.collection.get(title).equals(false)){
        this.collection.put(title, true);
      } else{
        throw new RuntimeException(title + " has already been returned/not existing");
      }
    }

    /**
     * returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title a string that is the title being checked
     * @return boolean showing if the library contains the collection
     */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
      } else{
        return false;
      }
    }

    /**
     * return true if the title is available, false otherwise
     * @param title the String that is the title being checked
     * @return boolean showing the availability of the book
     */
    public boolean isAvailable(String title){
      if (this.collection.get(title).equals(true)){
        return true;
      } else{
        return false;
            }
    }
    
    /**
     * print the library's collection in a nice readable way
     */
    public void printCollection(){
      System.out.println("The library has: ");
      Set<String> keys = this.collection.keySet();
      for (String title: keys){
        if (this.collection.get(title).equals(true)) {
            System.out.println(title +"; status: Available");
        } else{
          System.out.println(title+ "; status: Checked out");
        }
      }
    }

    /**
     * overrided method showing available options for Library
     */
    @Override
    public void showOptions() {
          System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(String title)\n + removeTitle(String title)\n + checkOut(String title)\n + returnBook(String title)");
      }
    
    public static void main(String[] args) {
      Library hillyer = new Library("Hillyer", "Smith College", 2);
      try {
        hillyer.addTitle("The Little Prince");
        hillyer.addTitle("Lovely");
        hillyer.checkOut("Lovely");
        hillyer.printCollection();        
        System.out.println(hillyer.isAvailable("Lovely"));
        System.out.println(hillyer.isAvailable("The Little Prince"));
        hillyer.removeTitle("Lovely");
        System.out.println(hillyer.containsTitle("Price and Prejudice"));
        hillyer.addTitle("Price and Prejudice");
        hillyer.printCollection();

      } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } 
        hillyer.addTitle("Price and Prejudice");
        hillyer.printCollection();
      
    }
  
  }