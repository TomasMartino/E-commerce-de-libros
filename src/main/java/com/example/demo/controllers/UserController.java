package com.example.demo.controllers;

import com.example.demo.models.UserEntity;
import com.example.demo.services.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("denyAll()")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "api/usuario")
    @PreAuthorize("hasAuthority('CREATE')")
    public List<UserEntity> getUsuarios(){
        return userDao.getUsuarios();
    }
    @RequestMapping(value = "api/usuario/{id}", method= RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('DELETE')")
    public void eliminar(@PathVariable Long id){

        userDao.eliminar(id);
    }
    @RequestMapping(value = "api/usuario", method=RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public void registrarUsuario(@RequestBody UserEntity user){

        userDao.registrar(user);
    }
}
