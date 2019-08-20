package com.keguang.daily.designPattern.simpleFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 16:32
 * @ version: v1.0.0
 * @ description: 简单工厂模式
 */
public class Gardener {
    public static Fruit getFruit(String fruitPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clz = Class.forName(fruitPath);

        return (Fruit) clz.newInstance();
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {

        Properties properties = new Properties();
        properties.load(Gardener.class.getClassLoader().getResourceAsStream("simple-factory.properties"));

        Fruit fruit = Gardener.getFruit(properties.getProperty("apple"));
        fruit.grow();

        Fruit fruit2 = Gardener.getFruit(properties.getProperty("grape"));
        fruit2.grow();
    }
}
