package sinhhung.sneaker_shop.payload;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String image;
    private String name;
    private String description;
    private Double price;
    private String color;
}
