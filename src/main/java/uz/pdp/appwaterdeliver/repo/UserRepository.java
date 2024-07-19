package uz.pdp.appwaterdeliver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwaterdeliver.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}