package com.example.resource;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Component
@Path("/")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @Path("products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok().entity(productRepository.findAll()).build();
    }


    @Path("product/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") Long id) {
        return Response.ok().entity(productRepository. findAll(Arrays.asList(id))).build();
    }

    @Path("product")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProduct(Product product) {
        return Response.ok().entity(productRepository.save(product)).build();
    }

    @Path("product")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) {
        return Response.ok().entity(productRepository.save(product)).build();
    }

    @Path("product/{id}")
    @DELETE
    public Response deleteProduct(@PathParam("id") Long id) {
        productRepository.delete(id);
        return Response.ok().build();
    }


}
