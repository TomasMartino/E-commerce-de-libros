package com.example.demo.services;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicesImpl implements IProductoServices{
    @Autowired
    ProductoRepository productoRepository;

    /*mostrar*/
    public List<Producto> getAllProductos(){

        return (List<Producto>) productoRepository.findAll();
    }

    public Optional<Producto> getById(Long id){
        return productoRepository.findById(id);
    }
    /*guardar y crear*/
    public Producto newProducto(@RequestBody Producto newProducto){

        return productoRepository.save(newProducto);
    }


    /* modificar*/
    public Producto updateById(Producto request, Long id){

        Producto producto= productoRepository.findById(id).get();

        producto.setTitulo(request.getTitulo());
        producto.setAutor(request.getAutor());
        producto.setCantidad(request.getCantidad());
        producto.setGenero(request.getGenero());
        producto.setPublicacion(request.getPublicacion());
        producto.setSinopsis(request.getSinopsis());
        producto.setPrecio(request.getPrecio());
        producto.setImagen(request.getImagen());/*ver q onda con la imagen*/

        return producto;
    }
    /*delete*/
    public Boolean deleteProductpById (Long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
