import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private CustomerDAO customerDAO = new CustomerDAO();

    private booksDAO booksDAO = new booksDAO();

    private loansDAO loansDAO = new loansDAO();

    private Scanner sc = new Scanner(System.in);

    public void showMenu() {

        System.out.println("Welcome! Do you want to log in as customer or admin? c for customer/a for admin");

        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("a")) {
            while (true) {
                System.out.println("Welcome superduper cool admin what do you want to do?");

                System.out.println("---- MENU ----");
                System.out.println("1. Add new customer");
                System.out.println("2. Delete customer");
                System.out.println("3. view customer");
                System.out.println("4. Add books");
                System.out.println("5. Delete book");
                System.out.println("6. view Books");
                System.out.println("0. Quit");

                String choice = sc.nextLine();
                switch (choice) {
                    case "1": addCustomer();
                        break;
                    case "2": deleteCustomer();
                        break;
                    case "3": getAllCustomers();
                        break;
                    case "4": addBook();
                        break;
                    case "5": deleteBook();
                        break;
                        case "6": getAllBooks();
                            break;
                    case "0":
                        return;
                    default:
                }
            }
        }else if (answer.equalsIgnoreCase("c")) {
            while (true) {
                System.out.println("Welcome notsosuperduper cool customer what do you want to do?");


                System.out.println("---- MENU ----");
                System.out.println("1. Register new customer");
                System.out.println("2. View all customers details");
                System.out.println("3. Loan book");
                System.out.println("4. Return book");
                System.out.println("5. Current loans");
                System.out.println("6. List all books");
                System.out.println("0. Quit");


                String choice = sc.nextLine();
                switch (choice) {
                    case "1": addCustomer();
                        break;
                    case "2": getAllCustomers();
                        break;
                    case "3": LoanBook();
                        break;
                    case "4": returnBook();
                        break;
                    case "5": ListCurrentLoans();
                        break;
                    case "6": getAllBooks();
                        break;
                    case "0":
                        return;
                    default:
                }
            }
        }
    }
    private void getAllCustomers() {

        List<Customer> customers = customerDAO.getAllCustomers();
        System.out.println("customers:");
        customers.forEach(s -> System.out.println(s) );
    }

    public void addCustomer() {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();

        customerDAO.addCustomer(name,email);
    }
    public void deleteCustomer() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();

        customerDAO.deleteCustomer(id);
    }
    public void getAllBooks() {

        List<books> books = booksDAO.getAllBooks();
        System.out.println("books:");
        books.forEach(s -> System.out.println(s) );
    }
    public void addBook() {
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter author: ");
        String author = sc.nextLine();
        System.out.println("Is it available? Yes/No: ");
        String available = sc.nextLine();

        booksDAO.addBook(title,author,available);
    }
    public void deleteBook() {
        System.out.println("Enter book id: ");
        int bookid = sc.nextInt();

        booksDAO.deleteBook(bookid);
    }
    public void ListCurrentLoans() {
        System.out.println("What customer id do you have?");
        int customerid = sc.nextInt();
        List<loans> loans = loansDAO.ListCurrrentLoans(customerid);
        loans.forEach(loan -> System.out.println(loan));
    }
    public void LoanBook() {
        System.out.println("What customer id do you have?:");
        int customerid = sc.nextInt();
        sc.nextLine();

        System.out.println("What customer name do you have?:");
        String username = sc.nextLine();

        System.out.println("Enter book id: ");
        int bookid = sc.nextInt();


        loansDAO.LoanBook(customerid,bookid,username);
    }
    public void returnBook() {
        System.out.println("What customer id do you have?");
        int customerid = sc.nextInt();
        System.out.println("Enter book id for what book you want to return: ");
        int bookid = sc.nextInt();

        loansDAO.returnBook(customerid,bookid);
    }
}
