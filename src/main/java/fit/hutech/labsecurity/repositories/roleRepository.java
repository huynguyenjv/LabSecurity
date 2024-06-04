package fit.hutech.labsecurity.repositories;

import fit.hutech.labsecurity.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepository extends JpaRepository<Role, Integer> {
}
