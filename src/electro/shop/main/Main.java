package electro.shop.main;

import electro.shop.model.AdminLogin;
import electro.shop.model.CartItem;
import electro.shop.service.*;
import electro.shop.model.Product;
import electro.shop.model.Sale;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final CartService cartService = new CartService();
    private static final AdminService adminService = new AdminService();
    private static final ProductService productService = new ProductService();
    private static final SaleService saleService = new SaleService();
    private static final CustomerService customerService = new CustomerService();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isAdmin = false;
    private static boolean isAuthenticated = false;

    public static void main(String[] args) throws SQLException {
        mainMenu();
    }

    public static void mainMenu() throws SQLException {
        while (true) {
            System.out.println("📱 Mobile Shop Management System");
            while (true) {
                System.out.println("1️⃣  🛍️ Customer                 2️⃣   👨‍💼 Admin  \n3️⃣  ❌ Exit");
                int ch = Integer.parseInt(scanner.nextLine());
                switch (ch) {
                    case 1:

                        customerMenu();
                        break;
                    case 2:
                        System.out.println("Enter Admin Credentials:");
                        System.out.print("Username: ");
                        String username = scanner.nextLine().trim();
                        System.out.print("Password: ");
                        String password = scanner.nextLine().trim();

                        AdminLogin adminLogin = new AdminLogin(username, password);
                        boolean isAdminValid = adminService.checkAdminDetail(adminLogin);

                        if (isAdminValid) {
                            System.out.println("✅ Admin login successful.");
                            adminMenu();
                        } else {
                            System.out.println("❌ Incorrect username or password.");
                        }

                        break;
                    case 3:
                        System.out.println("👋 Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("INVALIT INPUT");

                }
            }
        }
    }

    private static void customerMenu() throws SQLException {
        while (true) {
            System.out.println("1️⃣ 🔑 Login");
            System.out.println("2️⃣ 🆕 Sign Up");
            System.out.println("3️⃣ 🔙 Back ");
            System.out.println("4️⃣ ❌ Exit");


            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:

                    signIn();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    mainMenu();
                    break;
                case 4:
                    System.out.println("👋 Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void adminMenu() throws SQLException {
        while (true) {

            System.out.println("1️⃣ Add Product");
            System.out.println("2️⃣ Update Product");
            System.out.println("3️⃣ View Products");
            System.out.println("4️⃣ Delete Product");
            System.out.println("5️⃣ view Best Selling Products");
            System.out.println("6️⃣ Generate Bill");
            System.out.println("7️⃣ 🔙 Back");
            System.out.println("8️⃣ ❌ Exit");

            // System.out.println("810⃣ ❌ Exit");


            int choice1 = Integer.parseInt(scanner.nextLine());


            switch (choice1) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    deleteProduct();

                    break;
                case 5:
                    viewBestSellingProducts();
                    break;
                case 6:
                    while (true) {
                        System.out.println("\n🛒 1️⃣  Add Product to Cart");
                        System.out.println("🛍️ 2️⃣  View Cart");
                        System.out.println("❌ 3️⃣  Remove Product from Cart");
                        System.out.println("🧾 4️⃣  Generate Bill");
                        System.out.println("🔙 5️⃣   Back");
                        System.out.println("🚪 6️⃣  Exit");
                       // System.out.println("🚪 7️⃣  Exit");

                        System.out.print("Choose an option: ");
                        int choice = Integer.parseInt(scanner.nextLine());

                        int userId = 1;

                        switch (choice) {
                            case 1:
                                // Add product to cart

                                addProductToCart(userId);
                                break;
                            case 2:
                                // View cart
                                viewCart(userId);
                                break;
                            case 3:
                                // Remove product from cart
                                removeProductFromCart(userId);
                                break;
                            case 4:
                                // Generate bill
                                generateBill(userId);
                                clearCart(userId);
                                break;

                            case 5 : adminMenu();
                                    break;
                            case 6:
                                System.out.println("Exiting system. Goodbye!");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                case 7:
                    mainMenu();
                    break;
                case 8:
                    System.out.println("👋 Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void addProductToCart(int userId) {
        System.out.print("Enter Product ID: ");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        try {
            cartService.addProductToCart(userId, productId, productName, price, quantity);
            System.out.println("Product added to cart.");
        } catch (SQLException e) {
            System.out.println("NOT IN STOCK  , INCORRECT INPUT  " );
        }
    }


    private static void viewCart(int userId) {
        try {
            List<CartItem> cartItems = cartService.getCartItems(userId);
            if (cartItems.isEmpty()) {
                System.out.println("Your cart is empty.");
            } else {
                System.out.println("Your Cart: ");
                for (CartItem item : cartItems) {
                    System.out.println(item.getProductName() + " - Quantity: " + item.getQuantity() + " - Total: $" + item.getTotalPrice());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error viewing cart: " + e.getMessage());
        }
    }


    private static void removeProductFromCart(int userId) {
        System.out.print("Enter Product ID to remove: ");
        int productId = Integer.parseInt(scanner.nextLine());

        try {
            cartService.removeProductFromCart(userId, productId);
            System.out.println("Product removed from cart.");
        } catch (SQLException e) {
            System.out.println("Error removing product from cart: " + e.getMessage());
        }
    }

    private static void generateBill(int userId) {
        try {
            double total = cartService.calculateTotal(userId);
            System.out.println("Your total bill is: $" + total);
        } catch (SQLException e) {
            System.out.println("Error generating bill: " + e.getMessage());
        }
    }

    private static void clearCart(int userId) {
        try {
            cartService.clearCart(userId);
            System.out.println("Your cart has been cleared.");
        } catch (SQLException e) {
            System.out.println("Error clearing cart: " + e.getMessage());
        }
    }

    private static void signIn() throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (customerService.authenticateCustomer(username, password)) {
            System.out.println("✅ Sign In successful!");

            while (true) {
                isAuthenticated = true;
                System.out.println("1️⃣ 🛒 View Products");
                System.out.println("2️⃣ 💸 Filter Products by Price");
                System.out.println("3️⃣ 🔥 View Best-Selling Products");
                System.out.println("4️⃣ 🎬 Back ");
                System.out.println("5️⃣ ❌ Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        viewProducts();
                        break;
                    case 2:
                        filterProductsByPrice();
                        break;
                    case 3:
                        viewBestSellingProducts();
                        break;
                    case 4:
                        customerMenu();
                        break;
                    case 5:
                        System.out.println("👋 Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("❌ Invalid choice!");

                }
            }
        } else {
            System.out.println("❌ Invalid credentials!");
        }
    }

    private static void filterProductsByPrice() {
        System.out.print("Enter minimum price: ₹");
        double minPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter maximum price: ₹");
        double maxPrice = Double.parseDouble(scanner.nextLine());


        List<Product> filteredProducts = productService.filterProductsByPrice(minPrice, maxPrice);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-9s | %-12s | %-6s |\n", "ID", "Product Name", "Price (₹)", "Brand", "Stock");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Product product : filteredProducts) {
            System.out.printf(" %-3d |  %-30s |  ₹%-9.2f |  %-12s |  %-6d%n",
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getBrand(),
                    product.getStockQuantity());

        }
        System.out.println("-------------------------------------------------------------------------------------");
    }


    private static void viewBestSellingProducts() {
        List<Product> bestSellers = saleService.getBestSellingProducts();
        System.out.println("📊 Best-Selling Products:");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf(" %-3s |  %-30s |  ₹%-9s |  %-12s |\n","ProductID","Name","Price","Brand");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Product product : bestSellers) {
            System.out.printf(" %-3d       |  %-30s |  ₹%-9.2f |  %-12s%n",
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getBrand());

        }
        System.out.println("-------------------------------------------------------------------------------------");
    }


    private static void createAccount() throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String email;
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim();

            // Validate email (must contain "gmail", "@", and ".com")
            if (Pattern.matches("^[a-z0-9._%+-]+@gmail\\.com$", email)) {
                break; // Valid email, exit loop
            } else {
                System.out.println("❌ Invalid email! Please enter a valid Gmail address (e.g., example@gmail.com).");
            }
        }

        String phone;
        while (true) {
            System.out.print("Enter phone: ");
            phone = scanner.nextLine().trim();

            // Validate phone number (must be exactly 10 digits)
            if (Pattern.matches("\\d{10}", phone)) {
                break; // Valid phone, exit loop
            } else {
                System.out.println("❌ Invalid phone number! Please enter a 10-digit number.");
            }
        }

        if (customerService.addCustomer(username, password, email, phone)) {
            System.out.println("✅ Account created successfully!");

            while (true) {
                System.out.println("1️⃣ 🛒 View Products");
                System.out.println("2️⃣ 💸 Filter Products by Price");
                System.out.println("3️⃣ 🔥 View Best-Selling Products");
                System.out.println("4️⃣ 🎬 Back ");
                System.out.println("5️⃣ ❌ Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        viewProducts();
                        break;
                    case 2:
                        filterProductsByPrice();
                        break;
                    case 3:
                        viewBestSellingProducts();
                        break;
                    case 4:
                        customerMenu();
                        break;
                    case 5:
                        System.out.println("👋 Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("❌ Invalid choice!");

                }
            }
        } else {
            System.out.println("❌ Failed to create account.");
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ₹");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter product brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter stock quantity: ");
        int stockQuantity = Integer.parseInt(scanner.nextLine());

        if (productService.addProduct(name, price, brand, stockQuantity)) {
            System.out.println("✅ Product added successfully!");
        } else {
            System.out.println("❌ Failed to add product.");
        }
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product price: ₹");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter new product brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter new stock quantity: ");
        int stockQuantity = Integer.parseInt(scanner.nextLine());

        if (productService.updateProduct(productId, name, price, brand, stockQuantity)) {
            System.out.println("✅ Product updated successfully!");
        } else {
            System.out.println("❌ Failed to update product.");
        }
    }

    private static void viewProducts() {
        List<Product> products = productService.getAllProducts();


        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-30s | %-10s | %-12s | %-6s |\n", "ID", "Product Name", "Price (₹)", "Brand", "Stock");
        System.out.println("-------------------------------------------------------------------------------------");

        // Print product details in structured format
        for (Product product : products) {
            System.out.printf("| %-5d | %-30s | ₹%-9.2f | %-12s | %-6d |\n",
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getBrand(),
                    product.getStockQuantity());
        }

        System.out.println("-------------------------------------------------------------------------------------");

    }

    private static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int productId = Integer.parseInt(scanner.nextLine());

        if (productService.deleteProduct(productId)) {
            System.out.println("✅ Product deleted successfully!");
        } else {
            System.out.println("❌ Failed to delete product.");
        }
    }

}

