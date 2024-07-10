package demo.EmployeeManagementSystem.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import demo.EmployeeManagementSystem.Model.Log;
@Repository
public class LogDao {
	@Autowired
	private JdbcTemplate jdbctemp;
	
	
	private static class LogRowMapper implements RowMapper<Log>{
		
		@Override
        public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
			Log log = new Log();
            log.setId(rs.getLong("id"));
            log.setTimestamp(rs.getTimestamp("timestamp"));
            log.setDetails(rs.getString("details"));
            return log;
        }
    }
	
	 public List<Log> findAll() {
	        return jdbctemp.query("SELECT * FROM log_table", new LogRowMapper());
	    }
	 
	public int insertLog(Log log) {
		// TODO Auto-generated method stub
		return jdbctemp.update("INSERT INTO log_table (timestamp, details) VALUES (?, ?)",
                log.getTimestamp(), log.getDetails());
		
	}

	
	
}
