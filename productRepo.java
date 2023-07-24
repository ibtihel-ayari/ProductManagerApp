package tech.getarrays.productmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.productmanager.model.product;
import java.util.Optional;

public interface productRepo extends JpaRepository<product , Long> {
    void deleteProductById(Long id);

    Optional<product> findEmployeeById(Long id);
}

