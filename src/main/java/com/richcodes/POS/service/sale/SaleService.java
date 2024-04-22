package com.richcodes.POS.service.sale;

import com.richcodes.POS.enitity.Sale;
import com.richcodes.POS.enitity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    void sales(Sale sale);
    void addShop(Shop shop);
    Shop getShopById(int theId);
    void updateShop(Shop shop);
    void deleteShop(int theId);
    List<Shop> getAllShop();
}
