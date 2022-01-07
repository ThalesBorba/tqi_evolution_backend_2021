package tqi.analiseDeCreditoApi.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static tqi.analiseDeCreditoApi.security.UserRoles.ADMIN;
import static tqi.analiseDeCreditoApi.security.UserRoles.CLIENTE;

@Repository("fake")
public class FakeUserDaoService implements UserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return getUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<User> getUsers() {
        List<User> users = Lists.newArrayList(
                new User(
                        "annasmith",
                        passwordEncoder.encode("password"),
                        CLIENTE.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "linda",
                        passwordEncoder.encode("password"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return users;
    }

}
