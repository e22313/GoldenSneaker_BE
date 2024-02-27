package sinhhung.sneaker_shop.service;

import sinhhung.sneaker_shop.entity.Product;
import sinhhung.sneaker_shop.payload.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
}
