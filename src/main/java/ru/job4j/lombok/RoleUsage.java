package ru.job4j.lombok;

public class RoleUsage {
    public static void main(String[] args) {
        Role role = Role.of()
                .id(1)
                .name("Rustam")
                .accessBy("ADMIN")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);
    }
}
