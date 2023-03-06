package spring;

import dao.CRUD;
import dao.Student;
import dao.StudentDaoConfiguration;
import dao.StudentDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(StudentDaoConfiguration.class, args);

        CRUD studentDao = (StudentDaoImpl) ctx.getBean("student");

        System.out.println("------------------------Read all------------------------------");

        studentDao.create(new Student(0, "Peter", 19));
        studentDao.create(new Student(1, "Mark", 20));
        studentDao.create(new Student(2, "Misha", 17));
        studentDao.create(new Student(3, "Orest", 14));

        studentDao.readAll().stream().forEach(System.out::println);
        System.out.println("------------------------Delete id=0--------------------------");

        studentDao.delete(0);
        studentDao.readAll().stream().forEach(System.out::println);
        System.out.println("-----------------------Read id=3-----------------------------");

        Student temp = studentDao.read(2);
        System.out.println(temp.toString());
        System.out.println("--------------------Update id=3 (age=99)--------------------------");

        temp.setAge(99);
        studentDao.update(temp);
        studentDao.readAll().stream().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");



    }

}
