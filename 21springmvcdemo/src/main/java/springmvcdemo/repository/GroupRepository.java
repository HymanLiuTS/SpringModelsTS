package springmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import springmvcdemo.authentication.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{

}
