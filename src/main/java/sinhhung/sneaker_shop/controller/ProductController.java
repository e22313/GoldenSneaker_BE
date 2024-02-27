package sinhhung.sneaker_shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinhhung.sneaker_shop.payload.ProductResponse;
import sinhhung.sneaker_shop.service.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "https://unique-chaja-849859.netlify.app/")
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<List<ProductResponse>> getProvinceController() {
        List<ProductResponse> productResponses = productService.getAllProduct();
        return ResponseEntity.ok(productResponses);
    }

}
