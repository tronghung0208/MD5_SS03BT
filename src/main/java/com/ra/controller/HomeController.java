package com.ra.controller;

import com.ra.entity.Category;
import com.ra.entity.Product;
import com.ra.service.category.CategoryService;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list);
        List<Product> listProduct=productService.findAll();
        model.addAttribute("listProduct",listProduct);
        return "home";
    }

}
