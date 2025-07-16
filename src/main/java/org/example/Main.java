package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        /*Student s1 = new Student();
        s1.setRollNo(9);
        s1.setsName("raju");
        s1.setsAge(27);*/

        /*Student s2 = null;*/
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("xxx");
        l1.setModel("ccc");
        l1.setRam(32);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("yyy");
        l2.setModel("hhh");
        l2.setRam(32);


        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Thommy");
        a1.setTech("java");
        a1.setLaptop(Arrays.asList(l1,l2));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        /*s1 = session.get(Student.class, 8);*/
        Transaction transaction = session.beginTransaction();

        /*session.persist(s1);*/
        /*session.remove(s1);*/
        session.persist(l1);
        session.persist(l2);
        session.persist(a1);
        transaction.commit();
        session.clear();
        Alien a2 = session.get(Alien.class, 101);
        System.out.println(a2);
        /*s2 = session.load(Student.class,3);*/
        session.close();
        sf.close();
        /*System.out.println(s1);*/
    }
}