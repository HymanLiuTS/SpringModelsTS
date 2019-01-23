package codenest.hiberatets.daoimpl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import codenest.hiberatets.dao.SpitterDao;
import codenest.hiberatets.model.Spitter;

public class SpitterDaoImpl extends HibernateDaoSupport implements SpitterDao {

	Session session = null;

	public void save(final Spitter spitter) {
		this.session.save(spitter);
	}

	public void update(Spitter spitter) {
		this.session.update(spitter);

	}

	public void delete(Spitter spitter) {
		this.session.delete(spitter);
	}

	public Spitter findByID(int id) {
		Spitter spitter = getHibernateTemplate().get(Spitter.class, id);
		return spitter;
	}

	public void openSession() {
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	public void closeSession() {
		if (session != null && session.isOpen())
			session.close();
	}

	public Transaction beginTransaction() throws Exception {
		if(this.session==null) {
			throw new Exception("session is null");
		}
		Transaction ts = this.session.beginTransaction();
		return ts;
	}
}
