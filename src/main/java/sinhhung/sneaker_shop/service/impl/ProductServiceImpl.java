package sinhhung.sneaker_shop.service.impl;

import org.springframework.stereotype.Service;
import sinhhung.sneaker_shop.entity.Product;
import sinhhung.sneaker_shop.payload.ProductResponse;
import sinhhung.sneaker_shop.repository.ProductRepository;
import sinhhung.sneaker_shop.service.CartService;
import sinhhung.sneaker_shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product item : productList){
            ProductResponse product = new ProductResponse();
            product.setId(item.getProductId());
            product.setName(item.getProductName());
            product.setImage(item.getProductImage());
            product.setDescription(item.getProductDescription());
            product.setColor(item.getProductColor());
            product.setPrice(item.getProductPrice());
            productResponses.add(product);
        }

        return productResponses;

    }
}
