package learn.spring.dbtest;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

@RunWith(SpringRunner.class)
//@SpringBootTest keep it commented otherwise loads SpringBootApplication class
@ContextConfiguration(classes={TestConfig.class})
@TestPropertySource("classpath:/jdbc-test.yaml")
@SqlConfig(dataSource="festivalDataSource")
@Sql("classpath:/db/scripts/cleanup/festival.schema.sql")
@Sql("classpath:/db/scripts/schema/festival.schema.sql")
@Sql("classpath:/db/scripts/schema/festival.table.sql")
public class SpringDbTestApplicationTests {
	
	@Autowired
	DataSource festivalDataSource;
	
	@Autowired
	private ConfigurableApplicationContext ctx;

	@Test
	public void contextLoads() {
		System.out.println(ctx.getEnvironment().getPropertySources());
		System.out.println(ctx.getEnvironment().getProperty("url"));
		JdbcTemplate jdbcTemplate = new JdbcTemplate(festivalDataSource);
		assertEquals(0, JdbcTestUtils.countRowsInTable(jdbcTemplate, "festival.festival"));
	}

}
