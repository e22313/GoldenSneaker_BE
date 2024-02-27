package sinhhung.sneaker_shop.payload;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {
    private  Long itemId;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
}
