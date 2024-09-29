package com.example.demo.services;

import com.example.demo.models.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getUsuarios() {
        /*String query="from ecommercespring.usuario";

        List<UserEntity> resultado = entityManager.createQuery(query).getResultList();
        return resultado;*/

        return (List<UserEntity>) userRepository.findAll();
    }
    public Optional<UserEntity> getById(Long id){
        return userRepository.findById(id);
    }
    @Override
    public void eliminar(Long id) {
        UserEntity user=entityManager.find(UserEntity.class, id);
        entityManager.remove(user);
    }

    @Override
    public void registrar(UserEntity user) {
        entityManager.merge(user);
    }
}
