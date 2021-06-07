package com.redis.Model;

import java.io.Serializable;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor 
@NoArgsConstructor
@RedisHash("Product")

public class Product implements Serializable{
    
    @Id
    private Integer id;
    private String nome;
    private Integer quantidade;
    private Long valor;

    
}

