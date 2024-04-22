package com.richcodes.POS.service.category;

import com.richcodes.POS.enitity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void addCategory(Category category);
    Category getCategoryById(Integer theId);
    void updateCategory(Category category);
    void deleteCategory(Integer theId);
    List<Category> getAllCategory();
}
