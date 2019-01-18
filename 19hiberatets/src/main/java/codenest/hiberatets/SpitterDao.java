package codenest.hiberatets;

public interface SpitterDao {
	void save(Spitter stock);
	void update(Spitter stock);
	void delete(Spitter stock);
	Spitter findByID(int id);
}
