package com.example.demo.services;

import com.example.demo.models.Producto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoServices {
    List<Producto> getAllProductos();
    Optional<Producto> getById(Long id);
    Producto newProducto(@RequestBody Producto newProducto);
    Producto updateById(Producto request, Long id);
    Boolean deleteProductpById (Long id);
}
