package tech.getarrays.productmanager.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.productmanager.model.product;
import tech.getarrays.productmanager.repo.productRepo;
import java.util.List;
import java.util.UUID;
import tech.getarrays.productmanager.exception.UserNotFoundException;


@Service
@Transactional
public class productService {

    private final productRepo productRepo ;
    @Autowired
    public productService (productRepo productRepo) {
        this.productRepo = productRepo;
    }

    public product addProduct(product product) {
        product.setId(Long.valueOf(UUID.randomUUID().toString()));
        product.setNom(String.valueOf(UUID.randomUUID().toString()));
        product.setPrix(Long.valueOf(UUID.randomUUID().toString()));
        product.setQuantite(Long.valueOf(UUID.randomUUID().toString()));

        return productRepo.save(product);
    }

    public List<product> findAllProducts() {
        return productRepo.findAll();
    }

    public product updateProduct(product product) {
        return productRepo.save(product);
    }

    public product findProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteProduct(Long id){
        productRepo.deleteProductById(id);
    }
}
