package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionEntity> permissionList = new HashSet<>();



    private RoleEntity(Builder builder) {
        this.id = builder.id;
        this.permissionList = builder.permissionList;
        this.roleEnum = builder.roleEnum;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private RoleEnum roleEnum;
        private Set<PermissionEntity> permissionList;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder roleEnum(RoleEnum roleEnum) {
            this.roleEnum = roleEnum;
            return this;
        }

        public Builder permissionList(Set<PermissionEntity> permissionList) {
            this.permissionList = permissionList;
            return this;
        }

        public RoleEntity build() {
            return new RoleEntity(this);
        }
    }



    public RoleEntity() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public Set<PermissionEntity> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set<PermissionEntity> permissionList) {
        this.permissionList = permissionList;
    }
}
