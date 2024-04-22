package com.richcodes.POS.service.product;

import com.richcodes.POS.enitity.Product;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.exceptions.ResourceNotFoundExceptions;
import com.richcodes.POS.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void addProduct(Product product) {
        if(productRepository.existsProductByBarcode(product.getBarcode())){
            throw  new DuplicateExceptions("Product already exists");
        }
        productRepository.save(product);
    }

    @Override
    public Product getProductById(int theId) {
        Optional<Product> result = productRepository.findById(theId);
        Product product = null;
        if (result.isPresent()) {
            product = result.get();
        }
        else {
            throw new ResourceNotFoundExceptions("Did not find product id - " + theId);
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(int theId){
        productRepository.deleteById(theId);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
