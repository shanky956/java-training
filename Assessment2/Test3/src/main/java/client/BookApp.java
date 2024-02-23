package client;

import java.util.Scanner;

import BookManagement.BookManager;

public class BookApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BookManager bm = new BookManager();
		int choice;

		while (true) {
			System.out.println("\n\n********|MENU|********");
			System.out.println("1. Create book");
			System.out.println("2. Read book by Id");
			System.out.println("3. Read all books");
			System.out.println("4. Update book");
			System.out.println("5. Delete book");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				bm.createBook();
				break;
			case 2:
				bm.readBookById();
				break;
			case 3:
				bm.readALLBooks();
				break;
			case 4:
				bm.updateBook();
				break;
			case 5:
				bm.deleteBook();
				break;
			case 6:
				System.out.println("\nThank You!!");
				System.exit(0);
				break;

			}
		}

	}

}
