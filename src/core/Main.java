/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import decorator.BreadDecorator;
import decorator.CakeDecorator;
import decorator.CoffeeDecorator;
import crud.BakeryProductCRUD;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Bread
        ArrayList<Bread> bread_elements = new ArrayList<>();
        BakeryProductCRUD<Bread> bread = new BakeryProductCRUD<>(bread_elements);
        bread_elements = breadList(bread_elements);

        // Cake
        ArrayList<Cake> cake_elements = new ArrayList<>();
        BakeryProductCRUD<Cake> cake = new BakeryProductCRUD<>(cake_elements);
        cake_elements = cakeList(cake_elements);

        // Coffee
        ArrayList<Coffee> coffee_elements = new ArrayList<>();
        BakeryProductCRUD<Coffee> coffee = new BakeryProductCRUD<>(coffee_elements);
        coffee_elements = coffeeList(coffee_elements);

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("=============== Login ==============");
            System.out.print("Enter username: ");
            String username = sc.next();

            System.out.print("Enter password: ");
            String password = sc.next();

            boolean invalidPassword = false; // Add this variable to check password match

            try {
                File file = new File("login.txt");
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] tokens = line.split(":");

                    if (tokens[0].equals(username) && tokens[1].equals(password)) {
                        System.out.println("Login successful!");
                        loggedIn = true;
                        int option;
                        do {
                            option = printMenu();
                            switch (option) {
                                case 1: {
                                    int option2;
                                    do {
                                        option2 = addMenu();
                                        switch (option2) {
                                            // Bread
                                            case 1:
                                try {
                                                while (true) {
                                                    System.out.println("Add new Bread:");
                                                    System.out.print("ID : ");
                                                    String newId = sc.nextLine();
                                                    // check if the ID already exists in the list of breads
                                                    if (bread.findByIdOrName(newId) != null) {
                                                        System.out.println("Error: Bread with ID " + newId + " already exists. Please enter a different ID.");
                                                    } else {
                                                        // if the ID is unique, break out of the loop and continue with the rest of the code
                                                        System.out.print("Name : ");
                                                        String newName = sc.nextLine();
                                                        System.out.print("Type : ");
                                                        String newType = sc.nextLine();
                                                        System.out.print("Weight : ");
                                                        float newWeight = sc.nextFloat();
                                                        System.out.print("Price : ");
                                                        float newPrice = sc.nextFloat();
                                                        //decorator
                                                        System.out.print("Do you want to add shape? (Y/N) : ");
                                                        String addShape = sc.next(); // ask the customer to enter Y/N to confirm whether they want to add shape information
                                                        Bread obj = new Bread(newId, newName, newType, newWeight, newPrice);
                                                        bread.createProduct(obj);
                                                        if (addShape.equalsIgnoreCase("Y")) {
                                                            System.out.print("Shape : ");
                                                            String newShape = sc.next();
                                                            BreadDecorator decoratedBread = new BreadDecorator(obj, newShape); // create new BreadDecorator object with new shape information
                                                            System.out.println("+--------+-------------------------+------------+---------------+------------+------------+");
                                                            System.out.println("|   ID   |         Name            |   Price    |     Type      |   Weight   |    Shape   |");
                                                            System.out.println("+--------+-------------------------+------------+---------------+------------+------------+");
                                                            System.out.println(decoratedBread.toString());
                                                            System.out.println("+--------+-------------------------+------------+---------------+------------+------------+");
                                                        }
                                                        System.out.println("Add new Bread successful");
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Cake
                                            case 2:
                                try {
                                                while (true) {
                                                    System.out.println("Add new Cake:");
                                                    System.out.print("ID : ");
                                                    String newId = sc.nextLine();
                                                    // check if the ID already exists in the list of cakes
                                                    if (bread.findByIdOrName(newId) != null) {
                                                        System.out.println("Error: Cake with ID " + newId + " already exists. Please enter a different ID.");
                                                    } else {
                                                        // if the ID is unique, break out of the loop and continue with the rest of the code
                                                        System.out.print("Name : ");
                                                        String newName = sc.nextLine();
                                                        System.out.print("Price : ");
                                                        float newPrice = sc.nextFloat();
                                                        System.out.print("Flavor : ");
                                                        String newFlavor = sc.next();
                                                        System.out.print("Size : ");
                                                        String newSize = sc.next();
                                                        //decorator
                                                        System.out.print("Do you want to frost the cake? (Y/N) : ");
                                                        String frostCake = sc.next(); // ask the customer if they want ice cream or not
                                                        Cake obj = new Cake(newId, newName, newPrice, newFlavor, newSize);
                                                        cake.createProduct(obj);
                                                        if (frostCake.equalsIgnoreCase("Y")) {
                                                            CakeDecorator decoratedCake = new CakeDecorator(obj, true); // create a new CakeDecorator object with icing information true
                                                            System.out.println("+--------+-----------------------+---------------+------------------+------------+-------------+");
                                                            System.out.println("|   ID   |         Name          |     Price     |      Flavor      |    Size    |    Frost    |");
                                                            System.out.println("+--------+-----------------------+---------------+------------------+------------+-------------+");
                                                            System.out.println(decoratedCake.toString());
                                                            System.out.println("+--------+-----------------------+---------------+------------------+------------+-------------+");
                                                        }
                                                        System.out.println("Add new Cake successfull");
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Coffee
                                            case 3:
                                try {
                                                while (true) {
                                                    System.out.println("Add new Coffee:");
                                                    System.out.print("ID : ");
                                                    String newId = sc.nextLine();
                                                    // check if the ID already exists in the list of coffees
                                                    if (bread.findByIdOrName(newId) != null) {
                                                        System.out.println("Error: Coffee with ID " + newId + " already exists. Please enter a different ID.");
                                                    } else {
                                                        // if the ID is unique, break out of the loop and continue with the rest of the code                                                      XZ
                                                        System.out.print("Name : ");
                                                        String newName = sc.nextLine();
                                                        System.out.print("Price : ");
                                                        float newPrice = sc.nextFloat();
                                                        System.out.print("Roast Type : ");
                                                        String newRoastType = sc.next();
                                                        System.out.print("Volume : ");
                                                        float newVolume = sc.nextFloat();
                                                        //decorator
                                                        System.out.print("Do you want to add flavor to your coffee? (Y/N) : ");
                                                        String addFlavor = sc.next(); // ask user if they want to add flavor to their coffee
                                                        Coffee obj = new Coffee(newId, newName, newPrice, newRoastType, newVolume);
                                                        coffee.createProduct(obj);
                                                        if (addFlavor.equalsIgnoreCase("Y")) {
                                                            System.out.print("What flavor do you want to add? : ");
                                                            String flavor = sc.next();
                                                            CoffeeDecorator decoratedCoffee = new CoffeeDecorator(obj, flavor); // create a new CoffeeDecorator object with the user's chosen flavor
                                                            System.out.println("+---------+------------------------------+--------------+---------------+------------+------------+");
                                                            System.out.println("|   ID    |             Name             |     Price    |   Roast Type  |   Weight   |   Flavor   |");
                                                            System.out.println("+---------+------------------------------+--------------+---------------+------------+------------+");
                                                            System.out.println(decoratedCoffee.toString());
                                                            System.out.println("+---------+------------------------------+--------------+---------------+------------+------------+");
                                                        }
                                                        System.out.println("Add new Coffee successfull");
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            //Exit
                                            case 4:
                                                System.out.println("Closing!");
                                                System.out.println("---------------------------------------");
                                                break;
                                            default:
                                                System.out.println("Invaild Choice");
                                        }
                                    } while (option2 != 4);
                                    break;
                                }

                                case 2: {
                                    int option2;
                                    do {
                                        option2 = updateMenu();
                                        switch (option2) {
                                            // Bread
                                            case 1:
                                try {
                                                System.out.print("Enter the Bread code or name to be corrected: ");
                                                String idOrName = sc.nextLine();
                                                Bread breadToUpdate = bread.findByIdOrName(idOrName);

                                                if (breadToUpdate == null) {
                                                    System.out.println("No products to be repaired.");
                                                    return;
                                                }
                                                System.out.println("Information about the bread you are update :");
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                System.out.println("|   ID   |         Name            |   Price    |     Type      |   Weight   |");
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                System.out.println(breadToUpdate.toString()); // display product information
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                System.out.print("Enter a new Name for bread (press Enter if you don't want to change it): ");
                                                String newName = sc.nextLine();
                                                if (!newName.isEmpty()) {
                                                    breadToUpdate.setName(newName);
                                                }
                                                System.out.print("Enter a new Price for the bread (enter 0 if you don't want to change): ");
                                                float newPrice = sc.nextFloat();
                                                sc.nextLine(); // Read out newline
                                                if (newPrice > 0) {
                                                    breadToUpdate.setPrice(newPrice);
                                                }
                                                System.out.print("Enter a new Type for bread (press Enter if you don't want to change it): ");
                                                String newType = sc.nextLine();
                                                if (!newType.isEmpty()) {
                                                    breadToUpdate.setType(newType);
                                                }
                                                System.out.print("Enter a new Weight for the bread (enter 0 if you don't want to change): ");
                                                float newWeight = sc.nextFloat();
                                                sc.nextLine(); // Read out newline
                                                if (newWeight > 0) {
                                                    breadToUpdate.setWeight(newWeight);
                                                }

                                                // Update product information
                                                bread.editProduct(breadToUpdate);
                                                System.out.println("You have successfully updated bread information: ");
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                System.out.println("|   ID   |         Name            |   Price    |     Type      |   Weight   |");
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                System.out.println(breadToUpdate.toString()); // display product information
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");

                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Cake
                                            case 2:
                                try {
                                                System.out.print("Enter the Cake code or name to be corrected: ");
                                                String idOrName = sc.nextLine();
                                                Cake cakeToUpdate = cake.findByIdOrName(idOrName);

                                                if (cakeToUpdate == null) {
                                                    System.out.println("No products to be repaired.");
                                                    return;
                                                }
                                                System.out.println("Information about the cake you are update :");
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                System.out.println("|   ID   |         Name          |     Price     |      Flavor      |    Size    |");
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                System.out.println(cakeToUpdate.toString()); // display product information
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                System.out.print("Enter a new Name for cake (press Enter if you don't want to change it): ");
                                                String newName = sc.nextLine();
                                                if (!newName.isEmpty()) {
                                                    cakeToUpdate.setName(newName);
                                                }
                                                System.out.print("Enter a new Price for the cake (enter 0 if you don't want to change): ");
                                                float newPrice = sc.nextFloat();
                                                sc.nextLine(); // Read out newline
                                                if (newPrice > 0) {
                                                    cakeToUpdate.setPrice(newPrice);
                                                }
                                                System.out.print("Enter a new Flavor for cake (press Enter if you don't want to change it): ");
                                                String newFlavor = sc.nextLine();
                                                if (!newFlavor.isEmpty()) {
                                                    cakeToUpdate.setFlavor(newFlavor);
                                                }
                                                System.out.print("Enter a new Size for the cake (enter 0 if you don't want to change): ");
                                                String newSize = sc.nextLine();
                                                if (!newFlavor.isEmpty()) {
                                                    cakeToUpdate.setSize(newSize);
                                                }

                                                // Update product information
                                                cake.editProduct(cakeToUpdate);
                                                System.out.println("You have successfully updated cake information: ");
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                System.out.println("|   ID   |         Name          |     Price     |      Flavor      |    Size    |");
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                System.out.println(cakeToUpdate.toString()); // display product information
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");

                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Coffee
                                            case 3:
                                try {
                                                System.out.print("Enter the Coffee code or name to be corrected: ");
                                                String idOrName = sc.nextLine();
                                                Coffee coffeeToUpdate = coffee.findByIdOrName(idOrName);

                                                if (coffeeToUpdate == null) {
                                                    System.out.println("No products to be repaired.");
                                                    return;
                                                }
                                                System.out.println("Information about the coffee you are update :");
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                System.out.println("|   ID    |             Name             |     Price    |   Roast Type  |   Weight   |");
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                System.out.println(coffeeToUpdate.toString()); // display product information
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                System.out.print("Enter a new Name for coffee (press Enter if you don't want to change it): ");
                                                String newName = sc.nextLine();
                                                if (!newName.isEmpty()) {
                                                    coffeeToUpdate.setName(newName);
                                                }
                                                System.out.print("Enter a new Price for the cake (enter 0 if you don't want to change): ");
                                                float newPrice = sc.nextFloat();
                                                sc.nextLine(); // Read out newline
                                                if (newPrice > 0) {
                                                    coffeeToUpdate.setPrice(newPrice);
                                                }
                                                System.out.print("Enter a new Roast Type for cake (press Enter if you don't want to change it): ");
                                                String newRoastType = sc.nextLine();
                                                if (!newRoastType.isEmpty()) {
                                                    coffeeToUpdate.setRoastType(newRoastType);
                                                }
                                                System.out.print("Enter a new Volume for the cake (enter 0 if you don't want to change): ");
                                                float newVolume = sc.nextFloat();
                                                sc.nextLine(); // Read out newline
                                                if (newVolume > 0) {
                                                    coffeeToUpdate.setVolume(newVolume);
                                                }

                                                // Update product information
                                                coffee.editProduct(coffeeToUpdate);
                                                System.out.println("You have successfully updated coffee information: ");
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                System.out.println("|   ID    |             Name             |     Price    |   Roast Type  |   Weight   |");
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                System.out.println(coffeeToUpdate.toString()); // display product information
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");

                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Exit
                                            case 4:
                                                System.out.println("Closing!");
                                                System.out.println("---------------------------------------");
                                                break;
                                            default:
                                                System.out.println("Invaild Choice");
                                        }
                                    } while (option2 != 4);
                                }
                                break;
                                // Delete
                                case 3: {
                                    int option2;
                                    do {
                                        option2 = deleteMenu();
                                        switch (option2) {
                                            //Bread
                                            case 1:
                                try {
                                                // Delete products by Bread id or name
                                                System.out.print("Enter the Bread ID or Name to delete: ");
                                                String idOrName = sc.next();
                                                Bread breadToDelete = bread.findByIdOrName(idOrName);
                                                if (breadToDelete == null) {
                                                    System.out.println("Not exist the bread");
                                                } else {
                                                    System.out.println("Information Bread performs deletion: ");
                                                    System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                    System.out.println("|   ID   |         Name            |   Price    |     Type      |   Weight   |");
                                                    System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                    System.out.println(breadToDelete.toString()); // display this product information
                                                    System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                    // Ask for confirmation before deleting
                                                    System.out.print("Are you sure you want to delete this bread? (Y/N): ");
                                                    String confirmation = sc.next();
                                                    if (confirmation.equalsIgnoreCase("Y")) {
                                                        bread.deleteProduct(breadToDelete);
                                                        System.out.println("Remove the bread, successfully");
                                                    } else {
                                                        System.out.println("Deletion canceled");
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            //Cake
                                            case 2:
                                try {
                                                // Delete products by Cake id or name
                                                System.out.print("Enter the Cake ID or Name to delete: ");
                                                String idOrName = sc.next();
                                                Cake cakeToDelete = cake.findByIdOrName(idOrName);
                                                if (cakeToDelete == null) {
                                                    System.out.println("Not exist the cake");
                                                } else {
                                                    System.out.println("Information Cake performs deletion: ");
                                                    System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                    System.out.println("|   ID   |         Name          |     Price     |      Flavor      |    Size    |");
                                                    System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                    System.out.println(cakeToDelete.toString()); // display this product information
                                                    System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                    // Ask for confirmation before deleting
                                                    System.out.print("Are you sure you want to delete this cake? (Y/N): ");
                                                    String confirmation = sc.next();
                                                    if (confirmation.equalsIgnoreCase("Y")) {
                                                        cake.deleteProduct(cakeToDelete);
                                                        System.out.println("Remove the cake, successfully");
                                                    } else {
                                                        System.out.println("Deletion canceled");
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            //Coffee
                                            case 3:
                                try {
                                                // Delete products by Coffee id or name
                                                System.out.print("Enter the Coffee ID or Name to delete: ");
                                                String idOrName = sc.next();
                                                Coffee coffeeToDelete = coffee.findByIdOrName(idOrName);
                                                if (coffeeToDelete == null) {
                                                    System.out.println("Not exist the coffee");
                                                } else {
                                                    System.out.println("Information Coffee performs deletion: ");
                                                    System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                    System.out.println("|   ID    |             Name             |     Price    |   Roast Type  |   Weight   |");
                                                    System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                    System.out.println(coffeeToDelete.toString()); // display this product information
                                                    System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                    // Ask for confirmation before deleting
                                                    System.out.print("Are you sure you want to delete this coffee? (Y/N): ");
                                                    String confirmation = sc.next();
                                                    if (confirmation.equalsIgnoreCase("Y")) {
                                                        coffee.deleteProduct(coffeeToDelete);
                                                        System.out.println("Remove the coffee, successfully");
                                                    } else {
                                                        System.out.println("Deletion canceled");
                                                    }
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Exit
                                            case 4:
                                                System.out.println("Closing!");
                                                System.out.println("---------------------------------------");
                                                break;
                                            default:
                                                System.out.println("Invaild Choice");
                                        }
                                    } while (option2 != 4);
                                }
                                break;
                                // Search
                                case 4: {
                                    int option2;
                                    do {
                                        option2 = searchMenu();
                                        switch (option2) {
                                            //Bread
                                            case 1:
                                try {
                                                System.out.print("Search Bread by ID or Name: ");
                                                String idOrName = sc.nextLine();
                                                Bread breadToSearch = bread.findByIdOrName(idOrName);
                                                if (breadToSearch != null) {
                                                    System.out.println("Found product: ");
                                                    System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                    System.out.println("|   ID   |         Name            |   Price    |     Type      |   Weight   |");
                                                    System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                    System.out.println(breadToSearch);
                                                    System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                } else {
                                                    System.out.println("Bread not found");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            //Cake
                                            case 2:
                                try {
                                                System.out.print("Search Cake by ID or Name: ");
                                                String idOrName = sc.nextLine();
                                                Cake cakeToSearch = cake.findByIdOrName(idOrName);
                                                if (cakeToSearch != null) {
                                                    System.out.println("Found product: ");
                                                    System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                    System.out.println("|   ID   |         Name          |     Price     |      Flavor      |    Size    |");
                                                    System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                    System.out.println(cakeToSearch);
                                                    System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                } else {
                                                    System.out.println("Cake not found");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            //Coffee
                                            case 3:
                                try {
                                                System.out.print("Search Coffee by ID or Name: ");
                                                String idOrName = sc.nextLine();
                                                Coffee coffeeToSearch = coffee.findByIdOrName(idOrName);
                                                if (coffeeToSearch != null) {
                                                    System.out.println("Found product: ");
                                                    System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                    System.out.println("|   ID    |             Name             |     Price    |   Roast Type  |   Weight   |");
                                                    System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                    System.out.println(coffeeToSearch);
                                                    System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                } else {
                                                    System.out.println("Coffee not found");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            // Exit
                                            case 4:
                                                System.out.println("Closing!");
                                                System.out.println("---------------------------------------");
                                                break;
                                            default:
                                                System.out.println("Invaild Choice");
                                        }
                                    } while (option2 != 4);
                                    break;
                                }
                                // Display
                                case 5: {
                                    int option2;
                                    do {
                                        option2 = displayMenu();
                                        switch (option2) {
                                            case 1:
                                try {
                                                System.out.println("Display All Bread: ");
                                                ArrayList<Bread> allBread = bread.getAll(bread_elements);
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                System.out.println("|   ID   |         Name            |   Price    |     Type      |   Weight   |");
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                                for (int i = 0; i < allBread.size(); i++) {
                                                    System.out.println(allBread.get(i).toString());
                                                }
                                                System.out.println("+--------+-------------------------+------------+---------------+------------+");
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }

                                            break;

                                            case 2:
                                try {
                                                System.out.println("Display All Cake: ");
                                                ArrayList<Cake> allCake = cake.getAll(cake_elements);
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                System.out.println("|   ID   |         Name          |     Price     |      Flavor      |    Size    |");
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                                for (int i = 0; i < allCake.size(); i++) {
                                                    System.out.println(allCake.get(i).toString());
                                                }
                                                System.out.println("+--------+-----------------------+---------------+------------------+------------+");
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            case 3:
                                try {
                                                System.out.println("Display All Coffee: ");
                                                ArrayList<Coffee> allCoffee = coffee.getAll(coffee_elements);
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                System.out.println("|   ID    |             Name             |     Price    |   Roast Type  |   Weight   |");
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                                for (int i = 0; i < allCoffee.size(); i++) {
                                                    System.out.println(allCoffee.get(i).toString());
                                                }
                                                System.out.println("+---------+------------------------------+--------------+---------------+------------+");
                                            } catch (Exception e) {
                                                System.out.println("Error:" + e.getMessage());
                                            }
                                            break;
                                            case 4:
                                                System.out.println("Closing!");
                                                System.out.println("---------------------------------------");
                                                break;
                                            default:
                                                System.out.println("Invaild Choice");
                                        }
                                    } while (option2 != 4);
                                    break;
                                }
                                // Exit
                                case 6: {
                                    System.out.println("Closing!");
                                    break;
                                }
                            }
                        } while (option != 6);
                        sc.close();
                        break;
                    } else if (tokens[0].equals(username)) { // if username is correct but password is wrong
                        invalidPassword = true;
                    }
                }

                if (!loggedIn) {
                    if (invalidPassword) {
                        System.out.println("Invalid password. Please try again.");
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }

    }

    public static int printMenu() {
        // Print Menu
        System.out.println("+-------------------------------------------------+");
        System.out.println("|                       Menu                      |");
        System.out.println("+-------------------------------------------------+");
        System.out.println("| Select an option:                               |");
        System.out.println("|                                                 |");
        System.out.println("|     1. Add New Product                          |");
        System.out.println("|     2. Edit Product Information                 |");
        System.out.println("|     3. Delete Product                           |");
        System.out.println("|     4. Search Product Information               |");
        System.out.println("|     5. Display Product Information              |");
        System.out.println("|     6. Exit                                     |");
        System.out.println("|                                                 |");
        System.out.println("+-------------------------------------------------+");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int addMenu() {
        // Add Menu
        System.out.println("╭────────────────────────╮");
        System.out.println("│                ADD MENU               │");
        System.out.println("├───────────────────────-┤");
        System.out.println("│     Please select an option:          │");
        System.out.println("│                                       │");
        System.out.println("│     1. Add Bread                      │");
        System.out.println("│     2. Add Cake                       │");
        System.out.println("│     3. Add Coffee                     │");
        System.out.println("│     4. Exit                           │");
        System.out.println("│                                       │");
        System.out.println("╰────────────────────────╯");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int displayMenu() {
        // Display Menu
        System.out.println("╭───────────────────────╮");
        System.out.println("│           DISPLAY MENU              │");
        System.out.println("├──────────────────────┤");
        System.out.println("│     Please select an option:        │");
        System.out.println("│                                     │");
        System.out.println("│     1. Display Bread                │");
        System.out.println("│     2. Display Cake                 │");
        System.out.println("│     3. Display Coffee               │");
        System.out.println("│     4. Exit                         │");
        System.out.println("│                                     │");
        System.out.println("╰───────────────────────╯");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int searchMenu() {
        // Search Menu

        System.out.println("╭───────────────────────╮");
        System.out.println("│             SEARCH MENU             │");
        System.out.println("├──────────────────────┤");
        System.out.println("│     Please select an option:        │");
        System.out.println("│                                     │");
        System.out.println("│     1. Search Bread                 │");
        System.out.println("│     2. Search Cake                  │");
        System.out.println("│     3. Search Coffee                │");
        System.out.println("│     4. Exit                         │");
        System.out.println("│                                     │");
        System.out.println("╰───────────────────────╯");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int updateMenu() {
        // Update Menu

        System.out.println("╭───────────────────────╮");
        System.out.println("│               EDIT MENU             │");
        System.out.println("├──────────────────────┤");
        System.out.println("│     Please select an option:        │");
        System.out.println("│                                     │");
        System.out.println("│     1. Edit Bread                   │");
        System.out.println("│     2. Edit Cake                    │");
        System.out.println("│     3. Edit Coffee                  │");
        System.out.println("│     4. Exit                         │");
        System.out.println("│                                     │");
        System.out.println("╰───────────────────────╯");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int deleteMenu() {
        // Print Menu
        System.out.println("╭───────────────────────╮");
        System.out.println("│              DELETE MENU            │");
        System.out.println("├──────────────────────┤");
        System.out.println("│     Please select an option:        │");
        System.out.println("│                                     │");
        System.out.println("│     1. Delete Bread                 │");
        System.out.println("│     2. Delete Cake                  │");
        System.out.println("│     3. Delete Coffee                │");
        System.out.println("│     4. Exit                         │");
        System.out.println("│                                     │");
        System.out.println("╰───────────────────────╯");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static ArrayList<Bread> breadList(ArrayList<Bread> bread_elements) {
        Bread basicWhiteBread = new Bread("B001", "Basic White Bread", "Loaf", 0.45f, 1.99f);
        Bread sourdoughBread = new Bread("B002", "Sourdough Bread", "Round", 0.65f, 3.49f);
        Bread wholeGrainBread = new Bread("B003", "Whole Grain Bread", "Loaf", 0.55f, 2.99f);
        bread_elements.add(basicWhiteBread);
        bread_elements.add(sourdoughBread);
        bread_elements.add(wholeGrainBread);
        return bread_elements;
    }

    public static ArrayList<Cake> cakeList(ArrayList<Cake> cake_elements) {
        Cake chocolateCake = new Cake("C001", "Chocolate Cake", 20.5f, "Chocolate", "Large");
        Cake vanillaCake = new Cake("C002", "Vanilla Cake", 15.0f, "Vanilla", "Small");
        Cake birthdayCake = new Cake("C003", "Birthday Cake", 35.0f, "Chocolate", "Large");
        cake_elements.add(chocolateCake);
        cake_elements.add(vanillaCake);
        cake_elements.add(birthdayCake);
        return cake_elements;
    }

    public static ArrayList<Coffee> coffeeList(ArrayList<Coffee> coffee_elements) {
        Coffee colombianMediumRoast = new Coffee("CF001", "Colombian Medium Roast", 5.99f, "Medium", 0.35f);
        Coffee sumatranDarkRoast = new Coffee("CF002", "Sumatran Dark Roast", 6.99f, "Dark", 0.45f);
        Coffee guatemalanLightRoast = new Coffee("CF003", "Guatemalan Light Roast", 4.99f, "Light", 0.25f);
        coffee_elements.add(colombianMediumRoast);
        coffee_elements.add(sumatranDarkRoast);
        coffee_elements.add(guatemalanLightRoast);
        return coffee_elements;
    }

}
