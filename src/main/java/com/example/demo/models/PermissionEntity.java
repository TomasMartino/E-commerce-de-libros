package com.example.demo.models;

import com.example.demo.IBuilder;
import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String name;


    public PermissionEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PermissionEntity() {
    }






    private PermissionEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;

        private Builder() {
        }

        public Builder id(Long id) {

            this.id = id;
            return this;
        }
        public Builder name(String name) {

            this.name = name;
            return this;
        }

        public PermissionEntity build() {
            return new PermissionEntity(this);
        }
    }








    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
