package api5.cloudKitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "api5.cloudKitchen")
public class CloudKitchenApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudKitchenApplication.class, args);
    }
}
