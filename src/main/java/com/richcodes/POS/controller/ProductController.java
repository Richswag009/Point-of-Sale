package com.richcodes.POS.controller;

import com.richcodes.POS.enitity.Product;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.repository.ProductRepository;
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



    @GetMapping()
    public String index(Model model){
        Product product = new Product();
        List<Product> products= productService.getAllProduct();
        model.addAttribute("products",products);
        model.addAttribute("product",product);
        return "dashboard";
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
            @ModelAttribute("employee")
            int theId
    ){
        productService.deleteProduct(theId);
        return "redirect:/product";
    }
}
