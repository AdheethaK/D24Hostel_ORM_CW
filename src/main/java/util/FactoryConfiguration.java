package util;

import entity.Reservation;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        //add configuration
        Configuration configuration = new Configuration();

        //add properties
        Properties properties = new Properties();

        //add already created hibernate file to properties in current thread
        try {
            properties.load(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("application.properties"));//set path
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add properties to configure
        configuration.setProperties(properties);

        //add annotated class to configure
        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(Student.class);

        //build session factory
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null)?factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();//open session & return it
    }
}
