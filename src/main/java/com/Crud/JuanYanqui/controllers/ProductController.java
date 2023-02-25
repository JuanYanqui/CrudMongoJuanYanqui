package com.Crud.JuanYanqui.controllers;

import com.Crud.JuanYanqui.models.ProductDTO;
import com.Crud.JuanYanqui.repositories.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductDAO repository;

    @PostMapping("/product")
    public ProductDTO create(@Validated @RequestBody ProductDTO p) {
        return repository.insert(p);
    }

    @GetMapping("/")
    public List<ProductDTO> readAll() {
        return repository.findAll();
    }

    @PutMapping("/product/{id}")
    public ProductDTO update(@PathVariable String id, @Validated @RequestBody ProductDTO p) {
        ProductDTO pro = repository.findById(id).orElseThrow(RuntimeException::new);
        pro.setName(p.getName());
        pro.setPrice(p.getPrice());
        pro.setExpiry_date(p.getExpiry_date());
        return repository.save(pro);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
