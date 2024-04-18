package com.richcodes.POS.service.categoryService;

import com.richcodes.POS.enitity.Category;
import com.richcodes.POS.exceptions.DuplicateExceptions;
import com.richcodes.POS.exceptions.ResourceNotFoundExceptions;
import com.richcodes.POS.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void addCategory(Category category) {
        if(categoryRepository.existsCategoryByName(category.getName())){
            throw  new DuplicateExceptions("Category already exists");
        }
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int theId) {
        Optional<Category> result = categoryRepository.findById(theId);
        Category category = null;
        if (result.isPresent()) {
            category = result.get();
        }
        else {
            throw new ResourceNotFoundExceptions("Did not find employee id - " + theId);
        }
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(int theId){
        categoryRepository.deleteById(theId);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
