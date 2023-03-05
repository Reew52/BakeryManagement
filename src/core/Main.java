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
        ArrayList<Bread> bread_elements = new ArrayList<>();
        BakeryProductFactory<Bread> bread = new BakeryProductFactory<>(bread_elements);
        bread_elements = breadList(bread_elements);
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
                                String newId = sc.next();
                                System.out.print("Name : ");
                                String newName = sc.next();
                                System.out.print("Type : ");
                                String newType = sc.next();
                                System.out.print("Weight : ");
                                float newWeight = sc.nextFloat();
                                System.out.print("Price : ");
                                float newPrice = sc.nextFloat();
                                Bread obj = new Bread(newId, newName, newType, newWeight, newPrice);
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

                case 2:{
                    int option2;
                    do{
                        option2 = updateMenu();
                        switch (option2) {
                            case 1:
                                try {
                                    System.out.print("Nhập mã hoặc tên sản phẩm cần sửa: ");
                                    String idOrName = sc.nextLine();
                                    Bread breadToUpdate = bread.findByIdOrName(idOrName);
                                    
                                    if (breadToUpdate == null) {
                                        System.out.println("Không tìm thấy sản phẩm cần sửa.");
                                        return;
                                    }
                                    System.out.println(breadToUpdate.toString()); // hiển thị thông tin sản phẩm 
                                    System.out.print("Nhập tên mới cho sản phẩm (nhấn Enter nếu không muốn thay đổi): ");
                                    String newName = sc.nextLine();
                                    if (!newName.isEmpty()) {
                                        breadToUpdate.setName(newName);
                                    }
                                    System.out.print("Nhập Type mới cho sản phẩm (nhấn Enter nếu không muốn thay đổi): ");
                                    String newType = sc.nextLine();
                                    if (!newType.isEmpty()) {
                                        breadToUpdate.setType(newType);
                                    }
                                    System.out.print("Nhập giá mới cho sản phẩm (nhập 0 nếu không muốn thay đổi): ");
                                    float newWeight = sc.nextFloat();
                                    sc.nextLine(); // Đọc bỏ dòng newline
                                    if (newWeight > 0) {
                                        breadToUpdate.setWeight(newWeight);
                                    }
                                    System.out.print("Nhập giá mới cho sản phẩm (nhập 0 nếu không muốn thay đổi): ");
                                    float newPrice = sc.nextFloat();
                                    sc.nextLine(); // Đọc bỏ dòng newline
                                    if (newPrice > 0) {
                                        breadToUpdate.setPrice(newPrice);
                                    }

                                    // Cập nhật thông tin sản phẩm
                                    bread.editProduct(breadToUpdate);

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
                    }while (option2 != 4);
                }
                    break;
                    
                case 3: {
                    int option2;
                    do {
                        option2 = deleteMenu();
                        switch (option2) {
                            case 1:
                                try {
                                // xóa sản phẩm theo id hoặc tên sản phẩm
                                System.out.print("Nhập vào id hoặc tên sản phẩm cần xóa:");
                                String idOrName = sc.next();
                                Bread breadToDelete = bread.findByIdOrName(idOrName);
                                if (breadToDelete == null) {
                                    System.out.println("Not exist the bread");
                                } else {
                                    System.out.println("Thông tin Bread thực hiện xóa: ");
                                    System.out.println(breadToDelete.toString()); // hiển thị thông tin sản phẩm
                                    bread.deleteProduct(breadToDelete);
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
                                    System.out.print("Search Bread by ID or Name:");
                                    String idOrName = sc.next();
                                    Bread breadToSearch  = bread.findByIdOrName(idOrName);
                                        if (breadToSearch != null) {
                                            System.out.println("Tìm thấy sản phẩm:");
                                            System.out.println(breadToSearch);
                                            System.out.println("-----------------------------------------------------------------");
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

                case 5: {
                    int option2;
                    do {
                        option2 = displayMenu();
                        switch (option2) {
                            case 1:
//                                for (int i = 0; i < elements.size(); i++) {
//                                    System.out.println(elements.get(i).toString());
//                                }
                                try {
                                    ArrayList<Bread> allBread = bread.getAll(bread_elements);
                                    for (int i = 0; i < allBread.size(); i++) {
                                        System.out.println(allBread.get(i).toString());
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error:" + e.getMessage());
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
        // Add Menu
        System.out.println("-------------------ADD--------------------");
        System.out.println("Select an option:");
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
        // Display Menu
        System.out.println("-------------------Display--------------------");
        System.out.println("Select an option:");
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
        // Search Menu

        System.out.println("-------------------Search--------------------");
        System.out.println("Select an option:");
        System.out.println("1. Search Bread");
        System.out.println("2. Search Cake");
        System.out.println("3. Search Coffee");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }
    
    public static int updateMenu() {
        // Update Menu

        System.out.println("-------------------Edit--------------------");
        System.out.println("Select an option:");
        System.out.println("1. Edit Bread");
        System.out.println("2. Edit Cake");
        System.out.println("3. Edit Coffee");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int deleteMenu() {
        // Print Menu

        System.out.println("-------------------Delete--------------------");
        System.out.println("Select an option:");
        System.out.println("1. Delete Bread");
        System.out.println("2. Delete Cake");
        System.out.println("3. Delete Coffee");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static ArrayList<Bread> breadList(ArrayList<Bread> bread_elements) {
        Bread bread01 = new Bread("B001", "asdas", "asds", 123, 12);
        Bread bread02 = new Bread("B002", "adad", "afd", 234, 11);
        bread_elements.add(bread01);
        bread_elements.add(bread02);
        return bread_elements;
    }

}
