package com.example.demo.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String telefono;
    private String password;
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos = new ArrayList<>();
    /*relacion con Orden*/
    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes =new ArrayList<>();
    @Column(name= "is_enabled")
    private boolean isEnabled;
    @Column(name= "account_No_Expired")
    private boolean accountNoExpired;
    @Column(name= "account_No_Locked")
    private boolean accountNoLocked;
    @Column(name= "credemcial_No_Expired")
    private boolean credentialNoExpired;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    private UserEntity(UserEntityBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.password = builder.password;
        this.productos = builder.productos;
        this.ordenes = builder.ordenes;
        this.isEnabled = builder.isEnabled;
        this.accountNoExpired = builder.accountNoExpired;
        this.accountNoLocked = builder.accountNoLocked;
        this.credentialNoExpired = builder.credentialNoExpired;
        this.roles = builder.roles;
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public static final class UserEntityBuilder {
        private Long id;
        private String username;
        private String email;
        private String telefono;
        private String password;
        private List<Producto> productos = new ArrayList<>();
        private List<Orden> ordenes = new ArrayList<>();
        @Column(name = "is_enabled")
        private boolean isEnabled;
        @Column(name = "account_No_Expired")
        private boolean accountNoExpired;
        @Column(name = "account_No_Locked")
        private boolean accountNoLocked;
        @Column(name = "credential_No_Expired")
        private boolean credentialNoExpired;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<RoleEntity> roles = new HashSet<>();

        public UserEntityBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserEntityBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserEntityBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserEntityBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public UserEntityBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserEntityBuilder setProductos(Producto producto) {
            this.productos.add(producto);
            return this;
        }

        public UserEntityBuilder setOrdenes(Orden orden) {
            this.ordenes.add(orden);
            return this;
        }

        public UserEntityBuilder setIsEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public UserEntityBuilder setAccountNoExpired(boolean accountNoExpired) {
            this.accountNoExpired = accountNoExpired;
            return this;
        }

        public UserEntityBuilder setAccountNoLocked(boolean accountNoLocked) {
            this.accountNoLocked = accountNoLocked;
            return this;
        }

        public UserEntityBuilder setCredentialNoExpired(boolean credentialNoExpired) {
            this.credentialNoExpired = credentialNoExpired;
            return this;
        }

        public UserEntityBuilder setRoles(Set<RoleEntity> roles) {
            this.roles= roles;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String email, String telefono, String password, List<Producto> productos, List<Orden> ordenes, boolean isEnabled, boolean accountNoExpired, boolean accountNoLocked, boolean credentialNoExpired, Set<RoleEntity> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.productos = productos;
        this.ordenes = ordenes;
        this.isEnabled = isEnabled;
        this.accountNoExpired = accountNoExpired;
        this.accountNoLocked = accountNoLocked;
        this.credentialNoExpired = credentialNoExpired;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isAccountNoExpired() {
        return accountNoExpired;
    }

    public void setAccountNoExpired(boolean accountNoExpired) {
        this.accountNoExpired = accountNoExpired;
    }

    public boolean isAccountNoLocked() {
        return accountNoLocked;
    }

    public void setAccountNoLocked(boolean accountNoLocked) {
        this.accountNoLocked = accountNoLocked;
    }

    public boolean isCredentialNoExpired() {
        return credentialNoExpired;
    }

    public void setCredentialNoExpired(boolean credentialNoExpired) {
        this.credentialNoExpired = credentialNoExpired;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", password='" + password + '\'' +
                ", productos=" + productos +
                ", ordenes=" + ordenes +
                ", isEnabled=" + isEnabled +
                ", accountNoExpired=" + accountNoExpired +
                ", accountNoLocked=" + accountNoLocked +
                ", credentialNoExpired=" + credentialNoExpired +
                ", roles=" + roles +
                '}';
    }
}
