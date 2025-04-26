package videoshop.rating;

import jakarta.persistence.*;
import org.salespointframework.catalog.Product;
import org.salespointframework.useraccount.UserAccount;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    private int stars;

    @ManyToOne
    private Product product;

    @ManyToOne
    private UserAccount user;

    protected Rating() {}

    public Rating(Product product, UserAccount user, int stars) {
        this.product = product;
        this.user = user;
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public Product getProduct() {
        return product;
    }

    public UserAccount getUser() {
        return user;
    }
}

