package com.example.CarRentalApplication.service.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<F, T> {
    T map(F from);

    default List<T> map(List<F> froms) {
        if (froms == null) return Collections.emptyList();
        return froms.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
