package uz.pdp.appwaterdeliver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwaterdeliver.entity.District;

import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {
}