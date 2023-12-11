package com.ra.service.product;

import com.ra.entity.Product;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
  @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
                }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> optionalProduct =productRepository.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
productRepository.delete(findById(id));
    }
}
