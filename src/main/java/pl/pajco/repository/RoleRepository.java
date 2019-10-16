package pl.pajco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pajco.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByName(String name);

}
