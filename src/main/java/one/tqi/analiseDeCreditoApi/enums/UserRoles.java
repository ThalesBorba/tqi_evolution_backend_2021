package one.tqi.analiseDeCreditoApi.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static one.tqi.analiseDeCreditoApi.enums.UserPermissions.*;


public enum UserRoles {
    CLIENTE(Sets.newHashSet(CLIENTE_READ, CLIENTE_CREATE, EMPRESTIMO_READ, EMPRESTIMO_CREATE)),
    ADMIN(Sets.newHashSet(CLIENTE_READ, CLIENTE_MODIFY, EMPRESTIMO_READ, EMPRESTIMO_MODIFY));

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public
}


