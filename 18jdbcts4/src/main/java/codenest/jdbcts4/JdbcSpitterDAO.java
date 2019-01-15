package codenest.jdbcts4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSpitterDAO implements SpitterDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Spitter spitter) {

		String sql = "INSERT INTO spitter " + "(name, email) VALUES (?, ?)";

		jdbcTemplate.update(sql, new Object[] { spitter.getName(), spitter.getEmail() });

	}

	public void batchInsert(List<Spitter> spitters) {
		String sql = "INSERT INTO spitter " + "(name, email) VALUES (?, ?)";

		List<Object[]> batchArgs = new ArrayList<Object[]>();
		spitters.forEach((x) -> batchArgs.add(new Object[] { x.getName(), x.getEmail() }));
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	@Override
	public void deleteAll() {
		String sql = "delete from spitter";
		jdbcTemplate.update(sql);
	}

	@Override
	public Spitter getSpitterByID(long id) {
		String sql = "select * from spitter where id = ?";
		return (Spitter) this.jdbcTemplate.queryForObject(sql, new SpitterRowMapper() {

		}, id);
	}

	@Override
	public List<Spitter> getAllSpitters() {
		String sql = "select * from spitter";
		List<Spitter> customers = new ArrayList<Spitter>();

		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
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

		String name = (String) this.jdbcTemplate.queryForObject(sql, new Object[] { custId }, String.class);

		return name;

	}

	@Override
	public int findIdByName(String name) {
		String sql = "SELECT id FROM spitter WHERE name = ?";

		int id = this.jdbcTemplate.queryForObject(sql, new Object[] { name }, int.class);

		return id;
	}
}
