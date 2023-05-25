package lib;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> store = new ArrayList<>();

	public void addBook(String name, String authorName, double price, int numberOfCopies) {
		Book b = new Book(name, authorName);
		b.setPrice(price);
		b.setNumberOfCopies(numberOfCopies);
		store.add(b);
	}

	public boolean removeBook(Book book) {
		if (store.isEmpty())
			return false;
		boolean confirm = store.contains(book);
		if (confirm) {
			store.remove(book);
			return true;
		} else
			return false;
	}

	public synchronized boolean borrowBook(String name) {
		Book b = null;
		System.out.println("_______________________________");
		if (store.isEmpty()) {
			System.out.println("_______________________________");
			return false;
		}
		if (!isAvailable(name)) {
			System.out.println("_______________________________");
			return false;
		}
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getBookTitle().equalsIgnoreCase(name)) {
				b = store.get(i);
				System.out.println("Thanks For Borrowing");
				break;
			}
		}
		int copies = b.getNumberOfCopies();
		if (copies > 0)
			b.setNumberOfCopies(copies - 1);
		else if (copies == 0) {
			System.out.println("No Copies Left");
			System.out.println("_______________________________");
			return false;
		}
		System.out.println("Copies left : " + b.getNumberOfCopies());
		System.out.println("_______________________________");
		System.out.println();
		System.out.println();

		return true;
	}

	public boolean returnBook(String name) {
		System.out.println("_____________________________");
		Book b = null;
		int c = 0;
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getBookTitle().equalsIgnoreCase(name)) {
				b = store.get(i);
				c++;
				break;
			}
		}
		if (c == 0) {
			System.out.println("Book Not From This Store");
			System.out.println("_____________________________");
			return false;
		}
		int copies = b.getNumberOfCopies();
		if (copies == 0)
			b.setNumberOfCopies(1);
		else {

			b.setNumberOfCopies(copies + 1);
		}
		System.out.println("Thanks for returning : " + name);
		System.out.println("Copies left : " + b.getNumberOfCopies());
		System.out.println("_____________________________");
		System.out.println("_____________________________");
		System.out.println();
		System.out.println();
		return true;

	}

	public boolean isAvailable(String name) {
		Book b = null;
		System.out.println("_____________________________");
		int c = 0;
		if (store.isEmpty()) {
			System.out.println("_____________________________");
			return false;
		}
		for (int i = 0; i < store.size(); i++)
			if (store.get(i).getBookTitle().equalsIgnoreCase(name)) {
				b = store.get(i);
				c++;
				break;
			}
		if (c == 0) {
			System.out.println("Book Not In Library");
			System.out.println("_____________________________");
			return false;
		} else if (c == 1) {
			int copies = b.getNumberOfCopies();
			if (copies > 0) {
				System.out.println("Book \" " + b.getBookTitle() + " \" is available ");
				System.out.println("Number of Copies available : " + copies);
				System.out.println("_____________________________");
				System.out.println();
				return true;
			} else {
				System.out.println("No Copies left");
				System.out.println("_____________________________");
				return false;
			}
		}
		System.out.println("_____________________________");
		return false;
	}

	public void listAllBook() {
		if (store.isEmpty()) {
			System.out.println("Store Empty");
			return;
		}
		for (Book b : store) {
			System.out.println();
			System.out.println("Name :: " + b.getBookTitle());
			System.out.println("Author :: " + b.getAuthorName());
			System.out.println("Price :: " + b.getPrice());
			System.out.println("Number of Copies available :: " + b.getNumberOfCopies());
			System.out.println("______________________________________");
		}
	}
}
