package com.Crud.JuanYanqui.repositories;

import com.Crud.JuanYanqui.models.ProductDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDAO extends MongoRepository<ProductDTO, String> {


}