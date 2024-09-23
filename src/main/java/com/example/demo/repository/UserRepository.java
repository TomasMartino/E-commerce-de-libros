package com.example.demo.repository;

import com.example.demo.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //1:37:00
    Optional<UserEntity> findUserEntityByUsername( String username );

}
