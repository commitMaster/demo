package com.example.resource;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long id)
    {
        return productRepository.findAll(Arrays.asList(id)).stream().findFirst().orElse(new Product());
    }

    @RequestMapping(value = "/product", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/product", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/product/{id}",    method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        productRepository.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
