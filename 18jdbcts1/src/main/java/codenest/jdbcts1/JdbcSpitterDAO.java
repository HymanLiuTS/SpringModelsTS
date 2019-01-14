package codenest.jdbcts1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JdbcSpitterDAO implements SpitterDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Spitter spitter) {

		String sql = "INSERT INTO spitter " + "(name, email) VALUES (:name,:email)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", spitter.getName());
		params.put("email", spitter.getEmail());
		jdbcTemplate.update(sql, params);
	}

	public void batchInsert(List<Spitter> spitters) {
		String sql = "INSERT INTO spitter " + "(name, email) VALUES (:name,:email)";

		List<Map<String, Object>> batchArgs = new ArrayList<Map<String, Object>>();
		spitters.forEach((x) -> {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", x.getName());
			params.put("email", x.getEmail());
			batchArgs.add(params);
		});
		HashMap[] argsArr = new HashMap[batchArgs.size()]; 
		for(int i=0;i<batchArgs.size();i++) {
			argsArr[i]=new HashMap<String,Object>();
		}

		batchArgs.toArray(argsArr);
		jdbcTemplate.batchUpdate(sql, argsArr);
	}

	@Override
	public void deleteAll() {
		String sql = "delete from spitter";
		Map<String, Object> params = new HashMap<String, Object>();
		jdbcTemplate.update(sql, params);
	}

	@Override
	public Spitter getSpitterByID(long id) {
		String sql = "select * from spitter where id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return (Spitter) this.jdbcTemplate.queryForObject(sql, params, new SpitterRowMapper() {

		});
	}

	@Override
	public List<Spitter> getAllSpitters() {
		String sql = "select * from spitter";
		List<Spitter> customers = new ArrayList<Spitter>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql, params);
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

		String sql = "SELECT NAME FROM spitter WHERE id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", custId);
		String name = (String) this.jdbcTemplate.queryForObject(sql, params, String.class);

		return name;

	}

	@Override
	public int findIdByName(String name) {
		String sql = "SELECT id FROM spitter WHERE name = :name";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		int id = this.jdbcTemplate.queryForObject(sql, params, int.class);

		return id;
	}
}
