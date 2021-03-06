package tqi.analiseDeCreditoApi.security;

public enum UserPermissions {
    CLIENTE_READ("cliente:read"),
    CLIENTE_CREATE("cliente:create"),
    CLIENTE_MODIFY("cliente:modify"),
    EMPRESTIMO_READ("emprestimo:read"),
    EMPRESTIMO_CREATE("emprestimo:create"),
    EMPRESTIMO_MODIFY("emprestimo:modify");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
