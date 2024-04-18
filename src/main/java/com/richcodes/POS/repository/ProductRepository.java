package com.richcodes.POS.repository;

import com.richcodes.POS.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsProductByBarCode(String barCode);

}