package com.richcodes.POS.service.shop;

import com.richcodes.POS.enitity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    void addShop(Shop shop);
    Shop getShopById(int theId);
    void updateShop(Shop shop);
    void deleteShop(int theId);
    List<Shop> getAllShop();
}
