package ru.job4j.stream;

import java.util.List;
import java.util.stream.*;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> 0 <= product.getStandard() - product.getActual())
                .filter(product -> 3 >= product.getStandard() - product.getActual())
                .map(product -> new Label(product.getName(), product.getPrice() / 2).toString())
                .collect(Collectors.toList());
    }
}