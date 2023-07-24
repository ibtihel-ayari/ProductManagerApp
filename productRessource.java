package tech.getarrays.productmanager;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.productmanager.model.product;
import tech.getarrays.productmanager.service.productService;
import java.util.List;

@RestController
@RequestMapping("/product")
public class productRessource {
    private final productService productService;

    public productRessource(productService productService ) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<product>> getAllProducts () {
        List<product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<product> getProductById (@PathVariable("id") Long id) {
        product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<product> addProduct(@RequestBody product product) {
        product newproduct = productService.addProduct(product);
        return new ResponseEntity<>(newproduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<product> updateProduct(@RequestBody product product) {
        product updateProduct  = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
