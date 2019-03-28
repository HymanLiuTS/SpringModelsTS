package springmvcdemo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import springmvcdemo.authentication.model.Group;

@Repository("groupRepository")
public interface GroupRepository extends JpaRepository<Group, Long>{

}
