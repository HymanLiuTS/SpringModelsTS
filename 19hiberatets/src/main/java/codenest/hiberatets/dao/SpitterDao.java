package codenest.hiberatets.dao;

import org.hibernate.Transaction;

import codenest.hiberatets.model.Spitter;

public interface SpitterDao {

	void openSession();

	Transaction beginTransaction() throws Exception;

	void save(Spitter bo);

	void update(Spitter bo);

	void delete(Spitter bo);

	Spitter findByID(int id);

	void closeSession();
}
