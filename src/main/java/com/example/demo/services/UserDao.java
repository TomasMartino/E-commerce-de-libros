package com.example.demo.services;

import com.example.demo.models.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface UserDao {

    List<UserEntity> getUsuarios();

    void eliminar(Long id);

    void registrar(UserEntity user);
}
