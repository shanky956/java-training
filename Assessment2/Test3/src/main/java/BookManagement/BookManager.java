package BookManagement;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Book;
import util.HibernateUtil;

public class BookManager implements BookManagement {

	Scanner scanner = new Scanner(System.in);
	Session session;
	Transaction txn; 

	public BookManager() {

	}

	@Override
	public void createBook() {

		System.out.print("\nEnter Book Title:");
		String bookTitle = scanner.next();

		System.out.print("\nEnter Book Price:");
		double bookPrice = scanner.nextDouble();

		Book book = new Book(bookTitle, bookPrice);
		session = HibernateUtil.buildSessionFactory().openSession();
		txn = session.getTransaction();
		txn.begin();
		session.persist(book);
		txn.commit();
		session.close();

	}

	@Override
	public void readBookById() {
		// TODO Auto-generated method stub

		System.out.print("\nEnter the id: ");
		long bookId = scanner.nextLong();
		session = HibernateUtil.buildSessionFactory().openSession();
		txn = session.getTransaction();
		txn.begin();

		Book book = session.get(Book.class, bookId);
		txn.commit();
		session.close();

		if (book != null) {
			System.out.println("\nBook Id: " + book.getBookId());
			System.out.println("Book Title: " + book.getBookTitle());
			System.out.println("Book Price: " + book.getBookPrice());
		} else {
			System.out.println("\nNo book present with id: " + bookId);
		}
	}

	@Override
	public void readALLBooks() {

		session = HibernateUtil.buildSessionFactory().openSession();
		txn = session.getTransaction();
		txn.begin();
		
		Query query = session.createQuery("FROM Book");
		
		List<Book> books = query.getResultList();
		
		if(!books.isEmpty()) {
			for(Book newBook : books) {
				System.out.println("\n___________________________");
				System.out.println("Book Id: " + newBook.getBookId());
				System.out.println("Book Title: " + newBook.getBookTitle());
				System.out.println("Book Price: " + newBook.getBookPrice());
			}
		}
		else {
			System.out.println("No Books in the database");
		}
		txn.commit();
		session.close();

	}

	@Override
	public void updateBook() {
		// TODO Auto-generated method stub
		System.out.print("\nEnter the id: ");
		long bookId = scanner.nextLong();
		session = HibernateUtil.buildSessionFactory().openSession();
		txn = session.getTransaction();
		txn.begin();

		Book book = session.get(Book.class, bookId);
		txn.commit();
		session.close();
		
		if(book != null) {
			
			System.out.println("Book Title: " + book.getBookTitle());
			System.out.print("\nEnter New Book Title:");
			String bookTitle = scanner.next();

			System.out.println("Book Price: " + book.getBookPrice());
			System.out.print("\nEnter New Book Price:");
			double bookPrice = scanner.nextDouble();
			
			book.setBookTitle(bookTitle);
			book.setBookPrice(bookPrice);
			
			session = HibernateUtil.buildSessionFactory().openSession();
			txn = session.getTransaction();
			txn.begin();
			
			session.merge(book);
			
			txn.commit();
			session.close();
		}
		else {
			System.out.println("No book with id: "+bookId);
		}

	}

	@Override
	public void deleteBook() {
		System.out.print("\nEnter the id: ");
		long bookId = scanner.nextLong();
		session = HibernateUtil.buildSessionFactory().openSession();
		txn = session.getTransaction();
		txn.begin();

		Book book = session.get(Book.class, bookId);
		txn.commit();
		session.close();
		
		if(book != null) {
			
			session = HibernateUtil.buildSessionFactory().openSession();
			txn = session.getTransaction();
			txn.begin();
			
			session.remove(book);
			
			txn.commit();
			session.close();
		}
		else {
			System.out.println("No book with id: "+bookId);
		}
		
		

	}

}
