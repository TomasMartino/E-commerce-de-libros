package com.example.demo;

import com.example.demo.models.PermissionEntity;
import com.example.demo.models.RoleEntity;
import com.example.demo.models.RoleEnum;
import com.example.demo.models.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;
import static java.util.List.*;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @Bean
    CommandLineRunner init(UserRepository userRepository){
    return args -> {
        /* Create PERMISSIONS */
        PermissionEntity createPermission = PermissionEntity.builder()
                .name("CREATE")
                .build();

        PermissionEntity readPermission = PermissionEntity.builder()
                .name("READ")
                .build();

        PermissionEntity updatePermission = PermissionEntity.builder()
                .name("UPDATE")
                .build();

        PermissionEntity deletePermission = PermissionEntity.builder()
                .name("DELETE")
                .build();

        PermissionEntity refactorPermission = PermissionEntity.builder()
                .name("REFACTOR")
                .build();

        /* Create ROLES */
        RoleEntity roleAdmin = RoleEntity.builder()
                .roleEnum(RoleEnum.ADMIN)
                .permissionList(Set.of(readPermission, deletePermission, updatePermission, createPermission, refactorPermission))
                .build();

        RoleEntity roleUser = RoleEntity.builder()
                .roleEnum(RoleEnum.USER)
                .permissionList(Set.of(readPermission))
                .build();

        RoleEntity roleInvited = RoleEntity.builder()
                .roleEnum(RoleEnum.INVITED)
                .permissionList(Set.of(readPermission))
                .build();

        RoleEntity roleDeveloper = RoleEntity.builder()
                .roleEnum(RoleEnum.DEVELOPER)
                .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
                .build();

        /* CREATE USERS */
        UserEntity userSantiago = UserEntity.builder()
                .setUsername("santiago")
                .setPassword("123")
                .setIsEnabled(true)
                .setAccountNoExpired(true)
                .setAccountNoLocked(true)
                .setCredentialNoExpired(true)
				.setRoles(Set.of(roleAdmin))
                .build();

        UserEntity userDaniel = UserEntity.builder()
                .setUsername("daniel")
                .setPassword("1232")
                .setIsEnabled(true)
                .setAccountNoExpired(true)
                .setAccountNoLocked(true)
                .setCredentialNoExpired(true)
				.setRoles(Set.of(roleUser))
                .build();

        UserEntity userAndrea = UserEntity.builder()
                .setUsername("andrea")
                .setPassword("1235")
                .setIsEnabled(true)
                .setAccountNoExpired(true)
                .setAccountNoLocked(true)
                .setCredentialNoExpired(true)
				.setRoles(Set.of(roleInvited))
                .build();

        UserEntity userAnyi = UserEntity.builder()
                .setUsername("anyi")
                .setPassword("1234")
                .setIsEnabled(true)
                .setAccountNoExpired(true)
                .setAccountNoLocked(true)
                .setCredentialNoExpired(true)
				.setRoles( Set.of(roleDeveloper))
                .build();

        userRepository.saveAll(of(userSantiago, userDaniel, userAndrea, userAnyi));
    };
}
}
