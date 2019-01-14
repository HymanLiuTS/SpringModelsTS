package codenest.jdbcts;

import java.util.List;

public interface SpitterDAO {

	public void insert(Spitter spitter);

	public void batchInsert(List<Spitter> spitters);

	public void deleteAll();

	public Spitter getSpitterByID(long id);

	public List<Spitter> getAllSpitters();

	public String findNameById(int custId);

	public int findIdByName(String name);
}
