package com.bilgeadam.boost.java.course01.lesson068;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bilgeadam.boost.java.course01.lesson068.control.MovieEntityController;
import com.bilgeadam.boost.java.course01.lesson068.entity.MovieEntity;
import com.bilgeadam.boost.java.course01.lesson068.entity.RatingsEntity;

public class MainTest {
  public static void main(String[] args) {
    MovieEntityController movieController = new MovieEntityController();

    for (MovieEntity m : movieController.list()) {
      System.out.println(m);
    }
    // fetchA();
    // Scanner scan = new Scanner(System.in);
    // scan.nextLine();
    // System.out.println(movieEntity.getTags());

  }

  public static void fetchA() {

    MovieEntity movie = new MovieEntity();
    Configuration con = new Configuration().configure().addAnnotatedClass(MovieEntity.class)
        .addAnnotatedClass(RatingsEntity.class);
    SessionFactory sf = con.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    movie = session.get(MovieEntity.class, 1L); // id si 11 olan movies i getir db den
    tx.commit();
    System.out.println("////////////////");
    System.out.println("////////////////");
    System.out.println(movie);



  }
}
