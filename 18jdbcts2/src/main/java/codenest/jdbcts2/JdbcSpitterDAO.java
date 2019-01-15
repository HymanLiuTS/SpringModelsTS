package codenest.jdbcts2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcSpitterDAO extends JdbcDaoSupport implements SpitterDAO {

	
	public void insert(Spitter spitter) {

		String sql = "INSERT INTO spitter " + "(name, email) VALUES (?, ?)";

		getJdbcTemplate().update(sql, new Object[] { spitter.getName(), spitter.getEmail() });

	}

	public void batchInsert(List<Spitter> spitters) {
		String sql = "INSERT INTO spitter " + "(name, email) VALUES (?, ?)";

		List<Object[]> batchArgs = new ArrayList<Object[]>();
		spitters.forEach((x) -> batchArgs.add(new Object[] { x.getName(), x.getEmail() }));
		getJdbcTemplate().batchUpdate(sql, batchArgs);
	}

	@Override
	public void deleteAll() {
		String sql = "delete from spitter";
		getJdbcTemplate().update(sql);
	}

	@Override
	public Spitter getSpitterByID(long id) {
		String sql = "select * from spitter where id = ?";
		return (Spitter) this.getJdbcTemplate().queryForObject(sql, new SpitterRowMapper() {

		}, id);
	}

	@Override
	public List<Spitter> getAllSpitters() {
		String sql = "select * from spitter";
		List<Spitter> customers = new ArrayList<Spitter>();

		List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			Spitter spitter = new Spitter();
			spitter.setId((int) (row.get("ID")));
			spitter.setName((String) row.get("NAME"));
			spitter.setEmail((String) row.get("EMAIL"));
			customers.add(spitter);
		}
		return customers;
	}

	public String findNameById(int custId) {

		String sql = "SELECT NAME FROM spitter WHERE ID = ?";

		String name = (String) this.getJdbcTemplate().queryForObject(sql, new Object[] { custId }, String.class);

		return name;

	}

	@Override
	public int findIdByName(String name) {
		String sql = "SELECT id FROM spitter WHERE name = ?";

		int id = this.getJdbcTemplate().queryForObject(sql, new Object[] { name }, int.class);

		return id;
	}
}
