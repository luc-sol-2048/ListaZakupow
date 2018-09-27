package pl.lukasz.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukasz.shopping.model.User;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
