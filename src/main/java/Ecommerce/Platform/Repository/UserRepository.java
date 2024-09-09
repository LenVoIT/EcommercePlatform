package Ecommerce.Platform.Repository;

import Ecommerce.Platform.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
}