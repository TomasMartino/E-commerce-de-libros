package com.example.demo.controllers;

import com.example.demo.models.Producto;
import com.example.demo.services.IProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@PreAuthorize("denyAll()")
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IProductoServices iProductoServices;

    @PostMapping("/crearProducto")
    @PreAuthorize("hasAuthority('CREATE')")
    public Producto newProducto(@RequestBody Producto newProducto){
        return this.iProductoServices.newProducto(newProducto);
    }

    @GetMapping("")
    @PreAuthorize("permitAll()")
    public List<Producto> getAllProductos(){

        return this.iProductoServices.getAllProductos();
    }
    @GetMapping(path = "/{id}")
    @PreAuthorize("permitAll()")
    public Optional<Producto> getProductoById(@PathVariable Long id){
        return this.iProductoServices.getById(id);
    }


    @PutMapping(path = "/update/{id}")
    public Producto updateUserById(@RequestBody Producto request, Long id){
        return this.iProductoServices.updateById(request, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public String delete(@PathVariable("id") Long id){
        boolean ok = this.iProductoServices.deleteProductpById(id);
        if(ok){
            return"Producto with id "+ id +"deleted!";
        }else {
            return "Error, we have a problem and can t delete fot id "+id;
        }
    }

}
