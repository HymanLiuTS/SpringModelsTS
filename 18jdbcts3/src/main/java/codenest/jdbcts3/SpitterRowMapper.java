package codenest.jdbcts3;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpitterRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum){
		Spitter spitter=new Spitter();
		try {
			if(rs.wasNull()==false||rs.getRow()>0) {
				spitter.setId(rs.getInt(1));
				spitter.setName(rs.getString(2));
				spitter.setEmail(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spitter;
	}

}
