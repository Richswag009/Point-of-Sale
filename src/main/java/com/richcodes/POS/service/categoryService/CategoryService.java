package com.richcodes.POS.service.categoryService;

import com.richcodes.POS.enitity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void addCategory(Category category);
    Category getCategoryById(int theId);
    void updateCategory(Category category);
    void deleteCategory(int theId);
    List<Category> getAllCategory();
}
