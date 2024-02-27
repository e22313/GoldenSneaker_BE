package sinhhung.sneaker_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinhhung.sneaker_shop.entity.CartItem;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    Optional<CartItem> findCartItemByProductProductId(Long productId);

    void deleteCartItemByProductProductId(Long product_productId);



}
