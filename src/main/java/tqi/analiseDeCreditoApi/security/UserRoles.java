package tqi.analiseDeCreditoApi.security;

import com.google.common.collect.Sets;
import tqi.analiseDeCreditoApi.enums.UserPermissions;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static tqi.analiseDeCreditoApi.enums.UserPermissions.*;


public enum UserRoles {
    CLIENTE(Sets.newHashSet(CLIENTE_READ, CLIENTE_CREATE, EMPRESTIMO_READ, EMPRESTIMO_CREATE)),
    ADMIN(Sets.newHashSet(CLIENTE_READ, CLIENTE_MODIFY, EMPRESTIMO_READ, EMPRESTIMO_MODIFY));

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}


