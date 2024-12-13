package ru.job4j.lambda;

public class ConstructorRefMain {
    public static void main(String[] args) {
        FuncInterface modelConstructor = Model::new;
        Model model = modelConstructor.function("Example", 17);
        System.out.println("Значение равно: " + model.getName());
    }
}