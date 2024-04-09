package ru.job4j.lombok;

public class PermissionUsage {
    public static void main(String[] args) {
        Permission permission = Permission.add()
                .id(1)
                .name("Nebraska")
                .addRule("a")
                .addRule("b")
                .build();
        System.out.println(permission);
    }
}
