package springmvcdemo.common.repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springmvcdemo.authentication.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{

	public User findByUsername(String username);
	
	@Query(value = "select u.authorities,g.authorities from users u,groups g where u.id=1 and g.id in (select group_id from group_user_map m where user_id = 1)", nativeQuery = true)
	public List findAllAuthorities(Integer id);
}
