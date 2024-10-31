package vn.iostar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 
    private String images;

    @ManyToOne
    @JoinColumn(name = "productVariantId")
    private ProductVariant productVariant;
	
	
}
