package lib;

import java.io.*;

public class LibraryDesk extends Library {

	public static void owner(Library lb) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("OWNER MAIN MENU");
		System.out.println("================================");
		int choice;
		do {
			System.out.println("1: Add Book ");
			System.out.println("2: List All Books");
			System.out.println("3: Back");
			System.out.println("4: Exit ");
			System.out.print("Enter 1..4 : ");
			choice = Integer.parseInt(br.readLine());
			System.out.println();

			if (choice == 1) {
				String name, authname;
				double price;
				int copies;
				System.out.println("_______________________________");
				System.out.print("Enter Book name : ");
				name = br.readLine();
				System.out.println();
				System.out.print("Enter Author name : ");
				authname = br.readLine();
				System.out.println();
				System.out.print("Enter Price : ");
				price = Double.parseDouble(br.readLine());
				System.out.println();
				System.out.print("Enter Number of copies : ");
				copies = Integer.parseInt(br.readLine());
				System.out.println("_______________________________");

				lb.addBook(name, authname, price, copies);

			}

			if (choice == 2) {
				System.out.println("_______________________________");
				System.out.println(" List Of All books");
				lb.listAllBook();
				System.out.println("_______________________________");
			}

			if (choice == 3)
				break;

			if (choice == 4) {
				System.out.println("___________________________________");
				System.out.println("___________________________________");
				System.out.println("Thanks For Using The Application  ");
				System.out.println("___________________________________");
				System.out.println("___________________________________");
				System.exit(0);
			}

		} while (true);
	}

	public static void customer(Library lb) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("CUSTOMER MAIN MENU");
		System.out.println("=================================");
		int choice;
		do {
			System.out.println("1: Check out Book ");
			System.out.println("2: Return book ");
			System.out.println("3: Check Availability ");
			System.out.println("4: Back ");
			System.out.println("5: Exit ");
			System.out.print("Enter 1..5 : ");
			choice = Integer.parseInt(br.readLine());
			System.out.println();

			if (choice == 1) {
				System.out.println("_________________________");
				System.out.print("Enter Book Name : ");
				String name = br.readLine();
				lb.borrowBook(name);
			}

			if (choice == 2) {
				System.out.println("_________________________");
				System.out.print("Enter Book Name : ");
				String name = br.readLine();
				lb.returnBook(name);
			}

			if (choice == 3) {
				System.out.println("_________________________");
				System.out.print("Enter Book Name : ");
				String name = br.readLine();
				lb.isAvailable(name);
			}

			if (choice == 4)
				break;

			if (choice == 5) {
				System.out.println("_______________________________________");
				System.out.println("_______________________________________");
				System.out.println("Thanks For Using The Application  ");
				System.out.println("_______________________________________");
				System.out.println("_______________________________________");
				System.exit(0);
			}

		} while (true);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Library lb = new Library();
		int choice;
		do {
			System.out.println("_______________________________________");
			System.out.println("Library Owner Enter 1");
			System.out.println("Customer Enter 2");
			System.out.println("To exit press 3");
			System.out.println("_______________________________________");
			System.out.print("Enter :");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				LibraryDesk.owner(lb);
				break;
			case 2:
				LibraryDesk.customer(lb);
				break;
			case 3:
				System.out.println("_______________________________________");
				System.out.println("_______________________________________");
				System.out.println("Thanks For Using The Application  ");
				System.out.println("_______________________________________");
				System.out.println("_______________________________________");
				System.exit(0);
				break;
			}
		} while (true);
	}

}
