package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.repository;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

