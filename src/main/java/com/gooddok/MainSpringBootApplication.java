package com.gooddok;

import com.gooddok.dao.CustomerRepository;
import com.gooddok.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class MainSpringBootApplication implements CommandLineRunner{

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);

        if (args.length <= 0) {
            System.err.println("[Usage] java xxx.jar {insert name email | display}");
        } else {
            if (args[0].equalsIgnoreCase("insert")) {
                System.out.println("Add customer...");
                String name = args[1];
                String email = args[2];
                customerRepository.addCustomer(name, email);
            }

            if (args[0].equalsIgnoreCase("display")) {
                System.out.println("Display all customers...");
                List<Customer> list = customerRepository.findAll();
                list.forEach(System.out::println);
            }
            System.out.println("Done!");
        }
    }
}
