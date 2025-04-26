package videoshop.rating;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.salespointframework.catalog.Catalog;
import org.salespointframework.catalog.Product;
import org.salespointframework.useraccount.UserAccount;
import videoshop.rating.RatingRepository;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    private final Catalog<Product> catalog;
    private final RatingRepository ratingRepository;

    public RatingController(Catalog<Product> catalog, RatingRepository ratingRepository) {
        this.catalog = catalog;
        this.ratingRepository = ratingRepository;
    }

    @PostMapping("/{productId}")
    public String addRating(@PathVariable long productId, @RequestParam int stars, @AuthenticationPrincipal UserAccount user) {
        if (user == null) {
            return "redirect:/login";
        }

        Product product = catalog.findAll().stream()
        .filter(p -> p.getId().equals(productId))
        .findFirst()
        .orElse(null);


        Rating rating = new Rating(product, user, stars);
        ratingRepository.save(rating);

        return "redirect:/products/" + productId;
    }
}



