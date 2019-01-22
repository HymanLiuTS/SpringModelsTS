package codenest.hiberatets;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class SpitterDaoImpl extends HibernateDaoSupport implements SpitterDao {

	public void save(Spitter spitter) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(spitter);
		tx.commit();
		session.close();
	}

	public void update(Spitter spitter) {
		this.getHibernateTemplate().update(spitter);

	}

	public void delete(Spitter spitter) {
		this.getHibernateTemplate().delete(spitter);
	}

	public Spitter findByID(int id) {
		Spitter spitter=new Spitter();
		spitter.setId(id);
		List list = getHibernateTemplate().findByExample(spitter);
		return (Spitter) list.get(0);
	}

}
