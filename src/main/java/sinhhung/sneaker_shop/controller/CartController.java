package sinhhung.sneaker_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sinhhung.sneaker_shop.payload.CartItemResponse;
import sinhhung.sneaker_shop.payload.ProductResponse;
import sinhhung.sneaker_shop.payload.ResponseObject;
import sinhhung.sneaker_shop.service.CartService;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://unique-chaja-849859.netlify.app/")
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<List<CartItemResponse>> getAllCartItemController() {
        List<CartItemResponse> cartItemResponses = cartService.getAllCartItem();
        return ResponseEntity.ok(cartItemResponses);
    }

    @PostMapping("/add/{product_id}")
    public ResponseEntity<ResponseObject> add(@PathVariable Long product_id){
        ResponseObject responseObject = cartService.addToCart(product_id);
        return ResponseEntity.status(HttpStatus.OK).body(responseObject);
    }

    @PostMapping("/remove/{product_id}")
    public ResponseEntity<ResponseObject> remove(@PathVariable Long product_id){
        ResponseObject responseObject = cartService.removeFromCart(product_id);
        return ResponseEntity.status(HttpStatus.OK).body(responseObject);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<ResponseObject> deleteItem(@PathVariable Long product_id){
        ResponseObject responseObject = cartService.deleteCartItem(product_id);
        return ResponseEntity.status(HttpStatus.OK).body(responseObject);
    }


}
