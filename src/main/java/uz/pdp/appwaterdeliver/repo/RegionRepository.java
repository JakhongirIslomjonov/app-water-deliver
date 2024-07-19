package uz.pdp.appwaterdeliver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwaterdeliver.entity.Region;

import java.util.UUID;

public interface RegionRepository extends JpaRepository<Region, UUID> {
}