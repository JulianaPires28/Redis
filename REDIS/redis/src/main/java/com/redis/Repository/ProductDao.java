package com.redis.Repository;

import java.util.List;

import com.redis.Model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {

    @Autowired
    private RedisTemplate redisTemplate;

    public static final String HASH_KEY = "Product";

    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public Product update(Product product){
        redisTemplate.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }
        
    public List<Product> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);

    }
    public Product findById(int id){
        System.out.println("Called findById() from DB");
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }
    public String deleteProduto(int id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
        return "Product removed";
    }
    
}
