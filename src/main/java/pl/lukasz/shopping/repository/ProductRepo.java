package pl.lukasz.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukasz.shopping.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
