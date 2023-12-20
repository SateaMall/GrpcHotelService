package main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"models"})
@EnableJpaRepositories(basePackages = {"repositories"})
@SpringBootApplication(scanBasePackages = {"data","exceptions","controllers"})
class GrpcAgenceServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
