package sinhhung.sneaker_shop.service;

import org.hibernate.sql.Delete;
import sinhhung.sneaker_shop.payload.CartItemResponse;
import sinhhung.sneaker_shop.payload.ProductResponse;
import sinhhung.sneaker_shop.payload.ResponseObject;

import java.util.List;

public interface CartService {
    ResponseObject addToCart(Long productId);

    ResponseObject removeFromCart(Long productId);

    List<CartItemResponse> getAllCartItem();

    ResponseObject deleteCartItem(Long productId);

}
