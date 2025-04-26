package videoshop.rating;

import java.util.List;
import org.salespointframework.catalog.Product;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> findByProduct(Product product);
}
