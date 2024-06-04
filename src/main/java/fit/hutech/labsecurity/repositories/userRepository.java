package fit.hutech.labsecurity.repositories;

import fit.hutech.labsecurity.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, String> {
}
