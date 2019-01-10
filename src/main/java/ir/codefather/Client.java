package ir.codefather;

import ir.codefather.config.AppConfig;
import ir.codefather.drivers.DataBaseDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ir.codefather.service.UserService;

public class Client {
    public static void main(String[] args) {
        AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        DataBaseDriver mysql = appContext.getBean("mysqlDriver", DataBaseDriver.class);
        System.out.println("MySQL driver info:");
        System.out.println(mysql.getInfo());

        DataBaseDriver oracle = appContext.getBean("oracleDriver", DataBaseDriver.class);
        System.out.println("Oracle driver info:");
        System.out.println(oracle.getInfo());

        System.out.println("UserService Information");
        UserService userService = appContext.getBean(UserService.class);
        System.out.println(userService.getDriverInfo());

        appContext.close();
    }
}
