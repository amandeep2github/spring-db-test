package learn.spring.dbtest;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod="")//otherwise datasource close operation is closed twice
	@ConfigurationProperties("app.dataSource")
	public DataSource festivalDataSource(){
		DataSource ds = DataSourceBuilder.create().build();
		return ds;
	}
	

}
