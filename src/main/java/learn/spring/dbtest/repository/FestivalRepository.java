package learn.spring.dbtest.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FestivalRepository {
	@Autowired
	private DataSource festivalDataSource;
	
	
}
