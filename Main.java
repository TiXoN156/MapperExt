package com.company;

import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final String s = "{\n" +
            "\t\"name\":\"Барсик\",\n" +
            "\t\"age\":365,\n" +
            "\t\"master\":{\n" +
            "\t\t\"name\":\"Вася\",\n" +
            "\t\t\"adress\":{\n" +
            "\t\t\t\t\"city\":\"\",\n" +
            "\t\t\t\t\"street\": \"\"\n" +
            "\t\t\t},\n" +
            "\t\t\"job\":{\n" +
            "\t\t\t\t\"position\": {\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t}\n" +
            "}";

    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        try {
            Cat cat = mapper.parse(s, Cat.class);
            System.out.println();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
