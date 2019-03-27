package springmvcdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springmvcdemo.authentication.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{

}
