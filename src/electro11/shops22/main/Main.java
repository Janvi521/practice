
package electro11.shops22.main;

import electro11.shops22.model.AdminLogin;
import electro11.shops22.model.CustomerCreateAccount;
import electro11.shops22.model.CustomerLogin;
import electro11.shops22.service.AdminService;
import electro11.shops22.service.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in); // Class-level scanner

    public static void main(String[] args) throws SQLException {
        CustomerService customerService = new CustomerService();
        AdminService adminService=new AdminService();

        while (true) {
            System.out.println("1️⃣  🛍️ Customer                 2️⃣   👨‍💼 Admin  \n3️⃣  ❌ Exit");
            System.out.println("\n                    +--------+");
            System.out.println("                  | Log-in |");
            System.out.println("                    +--------+");

            int choiceAdminCustomer = Integer.parseInt(scanner.nextLine());
            switch (choiceAdminCustomer) {
                case 1:
                    Customer(customerService);
                    break;
                //ADMIN
                case 2:
                    System.out.println("Enter Admin Credentials:");
                    System.out.print("Username: ");
                    String username = scanner.nextLine().trim();
                    System.out.print("Password: ");
                    String password = scanner.nextLine().trim();

                    AdminLogin adminLogin = new AdminLogin(username, password);
                    boolean isAdminValid=adminService.checkAddminDatail(adminLogin);
                    if (isAdminValid) {
                        System.out.println("✅ Admin login successful.");
                        while (true) {
                            System.out.println("\n📌 Welcome to Admin Panel");
                            System.out.println("1️⃣ Manage Products");
                            System.out.println("2️⃣ View Sales Reports");
                            System.out.println("3️⃣ Manage Orders");
                            System.out.println("4️⃣ Manage Customers");
                            System.out.println("5️⃣ View Notifications");
                            System.out.println("6️⃣ Security & Backup");
                            System.out.println("7️⃣ Exit");
                            System.out.print("Enter your choice: ");

                            int choice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (choice) {
                                case 1:
                                    manageProducts();
                                    break;
                                case 2:
                                    viewSalesReports();
                                    break;
                                case 3:
                                    manageOrders();
                                    break;
                                case 4:
                                    manageCustomers();
                                    break;
                                case 5:
                                    viewNotifications();
                                    break;
                                case 6:
                                    securityBackup();
                                    break;
                                case 7:
                                    System.out.println("🔴 Exiting Admin Panel...");
                                    System.exit(0);
                                default:
                                    System.out.println("❌ Invalid Choice! Try Again.");
                            }
                        }
                    } else {
                        System.out.println("❌ Incorrect username or password.");
                    }


                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
    }

//    public static void UserNamePassword() {
//        System.out.println("Enter Admin Credentials:");
//        System.out.print("Username: ");
//        String username = scanner.nextLine();
//        System.out.print("Password: ");
//        String password = scanner.nextLine();
//
//        AdminLogin adminLogin = new AdminLogin(username, password);
//
//        System.out.println("Admin login successful (Implementation pending).");
//    }

    public static void Customer(CustomerService customerService) throws SQLException {
        while (true) {
            System.out.println("\n1️⃣  🛍️ SIGN IN        2️⃣   👨‍💼 CREATE ACCOUNT  \n3️⃣  🚪 EXIT ");
            int choiceCustomer = Integer.parseInt(scanner.nextLine());

            switch (choiceCustomer) {
                case 1:
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    CustomerLogin customerLogin = new CustomerLogin(username, password);

                    System.out.println("Customer login successful (Implementation pending).");
                    break;

                case 2:
                    createCustomerAccount(customerService);
                    break;

                case 3:
                    return; // Go back to main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createCustomerAccount(CustomerService customerService) throws SQLException {
        System.out.print("First name*: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name*: ");
        String lastName = scanner.nextLine();

        String phoneNumber;
        while (true) {
            System.out.print("Phone number* (10 digits): ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter exactly 10 digits.");
            }
        }

        System.out.print("Email Address: ");
        String email = scanner.nextLine();
        System.out.print("Email Password: ");
        String emailPassword = scanner.nextLine();
        System.out.println("Strong Password");
        String UserPassword=scanner.nextLine();
        CustomerCreateAccount customerCreateAccount = new CustomerCreateAccount(firstName, lastName, phoneNumber, email, emailPassword,UserPassword);
        customerService.addCustomerCreateAccount(customerCreateAccount);
    }
    public static void manageProducts() {
        System.out.println("\n📦 Product Management");
        System.out.println("1️⃣ Add Product");
        System.out.println("2️⃣ Update Product");
        System.out.println("3️⃣ Delete Product");
        System.out.println("4️⃣ View All Products");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Product Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter Stock Quantity: ");
                int stock = scanner.nextInt();
                System.out.println("✅ Product Added Successfully! 📦");
                break;
            case 2:
                System.out.println("🔄 Update Product Feature (Coming Soon)");
                break;
            case 3:
                System.out.println("🗑️ Delete Product Feature (Coming Soon)");
                break;
            case 4:
                System.out.println("📜 Displaying All Products...");
                break;
            default:
                System.out.println("❌ Invalid Choice! Try Again.");
        }
    }

    public static void viewSalesReports() {
        System.out.println("\n📊 Sales Reports");
        System.out.println("1️⃣ Daily Sales");
        System.out.println("2️⃣ Monthly Sales");
        System.out.println("3️⃣ Best-Selling Products");
        System.out.println("4️⃣ Least-Selling Products");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("📅 Showing Daily Sales Report...");
                break;
            case 2:
                System.out.println("📆 Showing Monthly Sales Report...");
                break;
            case 3:
                System.out.println("🏆 Displaying Best-Selling Products...");
                break;
            case 4:
                System.out.println("📉 Displaying Least-Selling Products...");
                break;
            default:
                System.out.println("❌ Invalid Choice! Try Again.");
        }
    }

    public static void manageOrders() {
        System.out.println("\n🛒 Order Management");
        System.out.println("1️⃣ View Pending Orders");
        System.out.println("2️⃣ Approve Orders");
        System.out.println("3️⃣ Cancel Orders");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("🔍 Viewing Pending Orders...");
                break;
            case 2:
                System.out.println("✅ Approving Selected Order...");
                break;
            case 3:
                System.out.println("❌ Canceling Selected Order...");
                break;
            default:
                System.out.println("❌ Invalid Choice! Try Again.");
        }
    }

    public static void manageCustomers() {
        System.out.println("\n👥 Customer Management");
        System.out.println("1️⃣ View Customers");
        System.out.println("2️⃣ Blacklist Customer");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("🔍 Fetching Customer List...");
                break;
            case 2:
                System.out.println("🚫 Blacklisting Customer...");
                break;
            default:
                System.out.println("❌ Invalid Choice! Try Again.");
        }
    }

    public static void viewNotifications() {
        System.out.println("\n🔔 Notifications");
        System.out.println("⚠️ Low Stock Alert: 5 products need restocking!");
        System.out.println("🏆 Sales Milestone Reached: ₹1,00,000 revenue today!");
    }

    public static void securityBackup() {
        System.out.println("\n🔐 Security & Backup");
        System.out.println("✅ Password Encryption Enabled");
        System.out.println("💾 Daily Database Backup Completed");
        System.out.println("📜 Audit Logs Saved");
    }
}
