package sinhhung.sneaker_shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinhhung.sneaker_shop.entity.CartItem;
import sinhhung.sneaker_shop.entity.Product;
import sinhhung.sneaker_shop.payload.CartItemResponse;
import sinhhung.sneaker_shop.payload.ProductResponse;
import sinhhung.sneaker_shop.payload.ResponseObject;
import sinhhung.sneaker_shop.repository.CartItemRepository;
import sinhhung.sneaker_shop.repository.ProductRepository;
import sinhhung.sneaker_shop.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private CartItemRepository cartItemRepository;
    private ProductRepository productRepository;

    public CartServiceImpl(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseObject addToCart(Long productId) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findCartItemByProductProductId(productId);
        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItemRepository.save(cartItem);
        } else {
            Optional<Product> productOptional = productRepository.findProductByProductId(productId);
            Product product = productOptional.get();
            CartItem newCartItem = new CartItem();
            newCartItem.setProduct(product);
            newCartItem.setQuantity(1);
            newCartItem.setPrice(product.getProductPrice());
            cartItemRepository.save(newCartItem);
        }
        return new ResponseObject(200,"Add success");
    }

    @Override
    public ResponseObject removeFromCart(Long productId) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findCartItemByProductProductId(productId);
        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            int newQuantity = cartItem.getQuantity() - 1;
            if (newQuantity <= 0) {
                cartItemRepository.delete(cartItem);
            } else {
                cartItem.setQuantity(newQuantity);
                cartItemRepository.save(cartItem);
            }
        }
        return new ResponseObject(200,"Remove success");

    }

    @Override
    public List<CartItemResponse> getAllCartItem() {
        List<CartItem> cartItemList = cartItemRepository.findAll();
        List<CartItemResponse> cartItemResponses = new ArrayList<>();
        for (CartItem item : cartItemList){
            CartItemResponse cartItem = new CartItemResponse();
            cartItem.setItemId(item.getItemId());
            cartItem.setQuantity(item.getQuantity());
            cartItem.setProductId(item.getProduct().getProductId());
            cartItemResponses.add(cartItem);
        }

        return cartItemResponses;
    }

    @Transactional
    @Override
    public ResponseObject deleteCartItem(Long productId) {
        cartItemRepository.deleteCartItemByProductProductId(productId);
        return new ResponseObject(200,"Remove success");
    }
}
