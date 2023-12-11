package com.ra.controller;

import com.ra.entity.Category;
import com.ra.entity.Product;
import com.ra.service.category.CategoryService;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductControler {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("add-product")
    public String addProduct(Model model){
        Product product =new Product();
        model.addAttribute("product",product);
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "product/add_product";
    }
    @PostMapping("add-product")
    public String addProduct(@ModelAttribute("product") Product product){
        Product newProduct=productService.saveOrUpdate(product);
        if (newProduct!=null){
            return "redirect:/";
        }
        return "product/add_product";
    }
    @GetMapping("edit-product/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        List<Category> categoryList=categoryService.findAll();
        Product editProduct = productService.findById(id);
        if (editProduct != null) {
            model.addAttribute("editProduct", editProduct);
            model.addAttribute("categoryList",categoryList);
            return "/product/edit_product";
        }
        return "redirect:/";
    }
@PostMapping("update-product")
    public String update(@ModelAttribute("editProduct") Product product){
    Product newProduct=productService.saveOrUpdate(product);
    if (newProduct!=null){
        return "redirect:/";
    }
    return "product/add_product";
}
@GetMapping("delete-product/{id}")
    public String delete(@PathVariable("id") Integer id){
        productService.delete(id);
return "redirect:/";
}
}
