package com.richcodes.POS.service.productService;

import com.richcodes.POS.enitity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void addProduct(Product product);
    Product getProductById(int theId);
    void updateProduct(Product product);
    void deleteProduct(int theId);
    List<Product> getAllProduct();
}
