package com.richcodes.POS.service.sale;

import com.richcodes.POS.enitity.Sale;
import com.richcodes.POS.enitity.Shop;
import com.richcodes.POS.exceptions.ResourceNotFoundExceptions;
import com.richcodes.POS.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private ShopRepository shopRepository;
    @Override
    public void addShop(Shop shop) {
//        if(shopRepository.existsShopByBarcode(shop.getBarcode())){
//            throw  new DuplicateExceptions("Shop already exists");
//        }
        shopRepository.save(shop);
    }

    @Override
    public Shop getShopById(int theId) {
        Optional<Shop> result = shopRepository.findById(theId);
        Shop shop = null;
        if (result.isPresent()) {
            shop = result.get();
        }
        else {
            throw new ResourceNotFoundExceptions("Did not find shop id - " + theId);
        }
        return shop;
    }

    @Override
    public void updateShop(Shop shop) {
        shopRepository.save(shop);

    }

    @Override
    public void deleteShop(int theId){
        shopRepository.deleteById(theId);
    }

    @Override
    public List<Shop> getAllShop() {
        return shopRepository.findAll();
    }

    @Override
    public void sales(Sale sale) {

    }
}
