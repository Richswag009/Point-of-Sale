package com.richcodes.POS.controller;

import com.richcodes.POS.enitity.Category;
import com.richcodes.POS.enitity.Product;
import com.richcodes.POS.enitity.Shop;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.repository.ProductRepository;
import com.richcodes.POS.service.ShopService.ShopService;
import com.richcodes.POS.service.categoryService.CategoryService;
import com.richcodes.POS.service.productService.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ShopService shopService;



    @GetMapping()
    public String index(Model model){
        Product product = new Product();
        List<Product> products= productService.getAllProduct();
        List<Category> categories = categoryService.getAllCategory();
        List<Shop> shops = shopService.getAllShop();
        model.addAttribute("products",products);
        model.addAttribute("product",product);
        model.addAttribute("categories",categories);
        model.addAttribute("shops",shops);
        return "product";
    }

    @PostMapping("/save")
    public String showForm(@ModelAttribute Product product, Model model) throws DuplicateExceptions {
        boolean productExists = productRepository.existsProductByBarcode(product.getBarcode());
        if(!productExists){
            productService.addProduct(product);
        }else{
            model.addAttribute("errorMessage", "Product already taken");
            return "dashboard";
        }
        return "redirect:/product";
    }


    @GetMapping("/delete")
    public String deleteEmployee(
            @RequestParam("productId")
            @ModelAttribute("product")
            int theId
    ){
        productService.deleteProduct(theId);
        return "redirect:/product";
    }
}
