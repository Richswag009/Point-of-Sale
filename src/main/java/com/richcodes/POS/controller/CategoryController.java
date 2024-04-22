package com.richcodes.POS.controller;

import com.richcodes.POS.enitity.Category;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.repository.CategoryRepository;
import com.richcodes.POS.service.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService ;
    @Autowired
    private CategoryRepository categoryRepository;



    @GetMapping()
    public String index(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        List<Category> categories= categoryService.getAllCategory();
        model.addAttribute("categories",categories);

        return "category";
    }

    @PostMapping("/save")
    public String showForm(@ModelAttribute Category category, Model model) throws DuplicateExceptions {
        boolean categoryExists = categoryRepository.existsCategoryByName(category.getName());
        if(!categoryExists){
            categoryService.addCategory(category);
        }else{
            model.addAttribute("errorMessage", "Category already exists");
            return "product";
        }
        return "redirect:/category";
    }


    @GetMapping("/delete")
    public String deleteEmployee(
            @RequestParam("categoryId")
            @ModelAttribute("category")
            int theId
    ){
        categoryService.deleteCategory(theId);
        return "redirect:/category";
    }
}
