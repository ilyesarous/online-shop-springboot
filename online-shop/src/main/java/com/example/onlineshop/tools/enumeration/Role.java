package com.example.onlineshop.tools.enumeration;

public enum Role {

    ADMIN("1"),
    CLIENT("2"),
    SELLER("3");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public Integer intValue() {
        return Integer.parseInt(this.getRoleName());
    }

}
