package com.expr;

import java.util.*;

public class LibraryManagementSys {
    private static final int MAX_LENGTH = 3;
    HashMap<String, Book> book = new HashMap<>();
    HashMap<String, Customer> customer = new HashMap<>();

    private class Book {
        String authorName;
        String bookName;
        double price;
        String bookId;
        boolean availability;

        Book(String authorName, String bookName, double price, String bookId) {
            this.authorName = authorName;
            this.bookName = bookName;
            this.bookId = bookId;
            this.price = price;
            this.availability = true;

        }

        public String toString() {

            return "author name: " + this.authorName + " ," + " book name:" + this.bookName + "," + " price:"
                    + this.price + ", book id:" + this.bookId;

        }

    }

    private class Customer {
       private final String custName;
        private final String custId;
         private final List<String> bookId;

        Customer(String custName, String custId) {
            this.custName = custName;
            this.custId = custId;
            this.bookId = new ArrayList<>();
        }

        public String toString() {
            return "customer name: " + this.custName + " , Customer id: " + this.custId
                    + ((this.bookId != null) ? ", book id " + this.bookId : ", No book rented");
        }

    }

    void add(Scanner sc) {
        System.out.println("enter author name");
        String authorName = sc.nextLine();
        System.out.println("enter book name");
        String bookName = sc.nextLine();
        System.out.println("enter book id");
        String bookId = sc.nextLine();
        System.out.println("enter price of the book");
        double price = sc.nextInt();
        sc.nextLine();
        if (this.book.containsKey(bookId)) {
            System.out.println("book id already exist.Cannot add book");
            return;
        }
        Book b = new Book(authorName, bookName, price, bookId);
        book.put(bookId, b);
        System.out.println("Book added successfully");
    }

    void remove(Scanner sc) {
        System.out.println("enter book id");
        String bookId = sc.nextLine();
        if(this.book.containsKey(bookId)&&!this.book.get(bookId).availability){
            System.out.println("Book is rented to someone else. Cannot remove it.");
            return;
        }
        Book b = this.book.remove(bookId);
        if (b != null) {
            System.out.println("Book removed successfully." + b);
        } else {
            System.out.println("book cannot be removed");
        }
    }

    void displayAvailableBooks(boolean isEmployee) {
        if(this.book.isEmpty()) {
            System.out.println("No books available");
            return;
        }
        System.out.println("These are the available books");
        for (Book b : book.values()) {
            if (b.availability) {
                System.out.println((isEmployee) ? b
                        : "author name: " + b.authorName + ", book name: " + b.bookName + ", rental price: "
                        + b.price);
            }
        }
    }

    void displayRentedBooks() {
        if(this.book.isEmpty()) {
            System.out.println("No books available");
            return;
        }
        System.out.println("These are the rented books");
        for (Book b : book.values()) {
            if (!b.availability) {
                System.out.println(b);
            }
        }
    }

    Customer customerInfo(Scanner sc) {
        System.out.println("enter customer name");
        String custName = sc.nextLine();
        System.out.println("enter customer id");
        String custId = sc.nextLine();
        return new Customer(custName, custId);
    }

    Optional<Customer> customerRegistration(Scanner sc) {
        Customer c = customerInfo(sc);
        if (validateCustomer(c)) {
            System.out.println("Customer with this id and name already exist.Would you like to login? Type yes or no ");
            String choice = sc.next().toLowerCase();
            if (choice.equals("yes")) {
                return Optional.of(this.customer.get(c.custId));
            }
            System.out.println("registration failed");
            return Optional.empty();

        }
        if (this.customer.containsKey(c.custId)) {
            System.out.println(
                    "customer having this id exist but with different name.If you need to change name of customer login as Employer");
            System.out.println("Registration failed due to invalid name");
            return Optional.empty();
        }

        this.customer.put(c.custId, c);
        System.out.println("registration successful");
        return Optional.empty();
    }

    boolean validateCustomer(Customer c) {
        return this.customer.containsKey(c.custId) && this.customer.get(c.custId).custName.equals(c.custName);
    }

    Optional<Customer> customerLogin(Scanner sc) {
        Customer c = customerInfo(sc);
        if (validateCustomer(c)) {
            System.out.println("login successful");
            return Optional.of(this.customer.get(c.custId));

        }
        System.out.println("login failed. Invalid Credentials");
        return Optional.empty();

    }

    void rentBook(Scanner sc, Customer c) {
        if (c.bookId.size() >= MAX_LENGTH) {
            System.out.println("cannot borrow books anymore as you have reached maximum limit,limit:" + MAX_LENGTH);
            return;
        }
        displayAvailableBooks(false);
        System.out.println("enter book name");
        String bookName = sc.nextLine();
        System.out.println("enter author name");
        String authorName = sc.nextLine();
        String foundKey = null;
        Book b = null;
        for (Map.Entry<String, Book> entry : this.book.entrySet()) {
            b = entry.getValue();
            if (b.bookName.equals(bookName) && b.authorName.equals(authorName) && b.availability) {
                foundKey = entry.getKey();
                break;
            }
        }

        if (foundKey != null) {
            c.bookId.add(foundKey);
            b.availability = false;
            System.out.println("Book rented successfully");

        } else {
            System.out.println("Book not found.");
        }

    }

    void returnBook(Scanner sc, Customer c) {
        if (c.bookId.size() <= 0) {
            System.out.println("No Book taken");
            return;
        }
        System.out.println("These are the books you have taken");
        int size=0;
        for (String s : c.bookId) {
            if (this.book.containsKey(s)) {
                size++;
                System.out.println(this.book.get(s));
            }
        }
        if(size!= c.bookId.size()){
            System.out.println("Book is missing.Consult with the service provider.");
            return;
        }
        while (c.bookId.size() > 0) {
            System.out.println("Want to return the book?.Type yes or no");
            String ch = sc.nextLine().toLowerCase().trim();
            if (ch.equals("yes")) {
                System.out.println("Return book with book id");
                String s = sc.nextLine();
                if ( c.bookId.contains(s)) {
                    Book b = this.book.get(s);
                    if (!b.availability) {
                        b.availability = true;
                        c.bookId.remove(s);
                        System.out.println("Book returned successfully");

                    }
                } else {
                    System.out.println("Book not found or not rented by you");
                }
            } else {
                System.out.println("returning cancelled");
                break;
            }

        }

    }

    void userInterface(Scanner sc) {
        while (true) {
            System.out.println("1 customer Registration");
            System.out.println("2 customer login");
            System.out.println("3 Return back");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 3) {
                return;
            }

            Optional<Customer> cust = switch (choice) {
                case 1 -> customerRegistration(sc);
                case 2 -> customerLogin(sc);
                default -> {
                    System.out.println("Invalid choice.");
                   yield  Optional.empty();
                }
            };


            if (cust.isPresent()) {
                while (true) {
                    System.out.println("Library Management System");
                    System.out.println("1 Rent book");
                    System.out.println("2 Return book");
                    System.out.println("3 Display available books");
                    System.out.println("4 Return Back");
                    System.out.println("Enter your choice");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    if (ch == 4) {
                        break;
                    }
                    switch (ch) {
                        case 1 -> rentBook(sc, cust.get());
                        case 2 -> returnBook(sc, cust.get());
                        case 3 -> displayAvailableBooks(false);
                        default -> System.out.println("invalid choice");

                    }

                }
            }

        }
    }

    void businessInterface(Scanner sc) {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1 add Book");
            System.out.println("2 Remove Book");
            System.out.println("3 Display Available Books");
            System.out.println("4 Display Rented Books");
            System.out.println("5 Return Back");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5) {
                return;
            }
            switch (ch) {
                case 1 -> add(sc);
                case 2 -> remove(sc);
                case 3 -> displayAvailableBooks(true);
                case 4 -> displayRentedBooks();
                default -> System.out.println("invalid choice");
            }
        }
    }

    void commonInterface(Scanner sc) {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("Select among these options");
            System.out.println("1 BusinessPerson");
            System.out.println("2 Customer");
            System.out.println("3 Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> businessInterface(sc);
                case 2 -> userInterface(sc);
                case 3 -> System.exit(0);
                default -> System.out.println("invalid choice");
            }

        }
    }
}
class LibraryMangSys {
    public static void main(String[] args) {
        LibraryManagementSys sy = new LibraryManagementSys();
        Scanner sc = new Scanner(System.in);

        sy.commonInterface(sc);
        sc.close();

    }
}
