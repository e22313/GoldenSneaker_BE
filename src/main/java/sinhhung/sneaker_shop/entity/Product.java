package sinhhung.sneaker_shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_IMAGE")
    private String productImage;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "PRODUCT_PRICE")
    private Double productPrice;

    @Column(name = "PRODUCT_COLOR")
    private String productColor;



}
