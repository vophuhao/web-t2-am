package vn.iostar.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String color;
    private double price;

    @Lob

    @OneToMany
    (mappedBy = "productVariant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   
    private List <ProductImage> productImage;
    
    
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    
    @OneToMany
    @JoinColumn(name = "size")
    private List<ProductSize> productSizes;
    
   
}
