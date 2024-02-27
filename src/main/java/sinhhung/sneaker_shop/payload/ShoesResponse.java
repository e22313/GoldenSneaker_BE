package sinhhung.sneaker_shop.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoesResponse {
    private List<ProductResponse> shoes;

}
