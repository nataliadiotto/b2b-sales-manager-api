package dev.diotto.sales_manager_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SalesManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerApiApplication.class, args);
		System.out.println("Hello World");
	}

}
