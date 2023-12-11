package com.ra.controller;

import com.ra.entity.Category;
import com.ra.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class CategoryControler {
    @Autowired
    CategoryService categoryService;
    @GetMapping("add")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add_category";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("category") Category category){
        Category newCategory=categoryService.saveOrUpdate(category);
        if (newCategory!=null){
            return "redirect:/";
        }
        return "category/add_category";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Category editCategory=categoryService.findById(id);
        model.addAttribute("editCategory",editCategory);
        return "category/edit_category";
    }


    @PostMapping("update")
    public String update(@ModelAttribute("editCategory") Category category){
        Category newCategory=categoryService.saveOrUpdate(category);
        if (newCategory!=null){
            return "redirect:/";
        }
        return "category/add_category";
    }
    @GetMapping("delete/{id}")

    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/";
    }
}
