package learn.spring.dbtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/jdbc.yaml")
public class SpringDbTestApplication implements CommandLineRunner{
	
	static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(SpringDbTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Press ctrl+c to terminate");
		Thread.currentThread().join();
		
	}
}
