package ru.job4j.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder(builderMethodName = "add")
public class Permission {
    private int id;
    private String name;

    @Singular("addRule")
    private List<String> rules;
}
