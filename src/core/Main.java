/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import factory.BakeryProductFactory;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Bread> elements = new ArrayList<>();
        BakeryProductFactory<Bread> bread = new BakeryProductFactory<>(elements);
        elements = breadList(elements);
        int option;
        do {
            option = printMenu();
            switch (option) {
                case 1: {
                    int option2;
                    do {
                        option2 = addMenu();
                        switch (option2) {
                            case 1:
                                try {
                                System.out.println("Add Bread:");
                                System.out.print("ID : ");
                                String id_bread = sc.next();
                                System.out.print("Name : ");
                                String name_bread = sc.next();
                                System.out.print("Type : ");
                                String type_bread = sc.next();
                                System.out.print("Weight : ");
                                float weight_bread = sc.nextFloat();
                                System.out.print("Price : ");
                                float price_bread = sc.nextFloat();
                                Bread obj = new Bread(id_bread, name_bread, type_bread, weight_bread, price_bread);
                                bread.createProduct(obj);
                                System.out.println("Add successfull");

                            } catch (Exception e) {
                                System.out.println("Error:" + e.getMessage());
                            }

                            break;

                            case 2:
                                System.out.println("Add Cake:");
                                break;
                            case 3:
                                System.out.println("Add Coffee:");

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

                case 2:
                    break;
                case 3: {
                    int option2;
                    do {
                        option2 = deleteMenu();
                        switch (option2) {
                            case 1:
                                try {
                                System.out.print("Delete Bread:");
                                String id_delete = sc.next();
                                Bread find_bread = bread.findByIdOrName(id_delete);
                                if (find_bread == null) {
                                    System.out.println("Not exist the bread");
                                } else {
                                    bread.deleteProduct(find_bread);
                                    System.out.println("Remove the bread, successfully");

                                }
                            } catch (Exception e) {
                                System.out.println("Error:" + e.getMessage());
                            }

                            break;

                            case 2:
                                System.out.println("Add Cake:");
                                break;
                            case 3:
                                System.out.println("Add Coffee:");

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
                case 4: {
                    int option2;
                    do {
                        option2 = searchMenu();
                        switch (option2) {
                            case 1:
                                try {
                                System.out.println("Search Bread by ID or Name:");
                                String idOrName = sc.next();
                                Bread search_bread = bread.findByIdOrName(idOrName);
                                if (search_bread != null) {
                                    System.out.println("Found bread: " + search_bread);
                                } else {
                                    System.out.println("Bread not found");
                                }
                            } catch (Exception e) {
                                System.out.println("Error:" + e.getMessage());
                            }

                            break;
                            case 2:
                                System.out.print("Search Cake by code: ");
                                break;
                            case 3:
                                System.out.print("Search Coffee by code: ");
                                break;
                            default:
                                System.out.println("Invaild Choice");
                        }
                    } while (option2 != 3);
                    break;
                }

                case 5: {
                    int option2;
                    do {
                        option2 = displayMenu();
                        switch (option2) {
                            case 1:
                                for (int i = 0; i < elements.size(); i++) {
                                    System.out.println(elements.get(i).toString());
                                }
                                break;
                            case 2:
                                System.out.print("Display Cake: ");
                                break;
                            case 3:
                                System.out.print("Display Coffee: ");
                                break;
                            case 4:
                                System.out.print("Display All: ");
                                break;
                            case 5:
                                System.out.println("Closing!");
                                System.out.println("---------------------------------------");
                                break;
                            default:
                                System.out.println("Invaild Choice");
                        }
                    } while (option2 != 5);
                    break;
                }

                case 6: {
                    System.out.println("Closing!");
                    break;
                }
            }
        } while (option != 6);
        sc.close();

    }

    public static int printMenu() {
        // Print Menu
        System.out.println("------------------------------------- Menu -------------------------------------");
        System.out.println("Select an option:");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. Search");
        System.out.println("5. Display");
        System.out.println("6. Exit");
        System.out.println("-------------------------------------------------------------------------------- ");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int addMenu() {
        // Print Menu	
        System.out.println("Add what?");
        System.out.println("1. Add Bread");
        System.out.println("2. Add Cake");
        System.out.println("3. Add Coffee");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int displayMenu() {
        // Print Menu
        System.out.println("Display what?");
        System.out.println("1. Display Bread");
        System.out.println("2. Display Cake");
        System.out.println("3. Display Coffee");
        System.out.println("4. Display All");
        System.out.println("5. Exit");
        System.out.println("---------------------------------------");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int searchMenu() {
        // Print Menu

        System.out.println("Search what?");
        System.out.println("1. Search Bread");
        System.out.println("2. Search Cake");
        System.out.println("3. Search Coffee");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int deleteMenu() {
        // Print Menu

        System.out.println("Delete what?");
        System.out.println("1. Delete Bread");
        System.out.println("2. Delete Cake");
        System.out.println("3. Delete Coffee");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static ArrayList<Bread> breadList(ArrayList<Bread> elements) {
        Bread bread01 = new Bread("B001", "asdas", "asds", 123, 12);
        Bread bread02 = new Bread("B002", "adad", "afd", 234, 11);
        elements.add(bread01);
        elements.add(bread02);
        return elements;
    }

}
