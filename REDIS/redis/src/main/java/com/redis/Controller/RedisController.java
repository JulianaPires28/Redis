package com.redis.Controller;

import java.util.List;

import com.redis.Model.Product;
import com.redis.Repository.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
@EnableCaching

public class RedisController {
    
    @Autowired
    private ProductDao productDao;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productDao.update(product);
    }


    @GetMapping
    public List<Product> getAllproduct(){
        return productDao.findAll();   
    }
    
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product", unless = "#result.valor>1000")
    public Product findById(@PathVariable int id){
        return productDao.findById(id);

    }
    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Product")
    public String deleteById(@PathVariable int id){
       return productDao.deleteProduto(id);
        
    }

    
}

