package com.keguang.daily.javabasic.java8.funcinterface;

/**
 * @ Author: keguang
 * @ Date: 2019/10/14 13:59
 * @ version: v1.0.0
 * @ description: 函数式接口
 * Java 语言设计者们投入了大量精力来思考如何使现有的函数友好地支持Lambda。
 * 最终采取的方法是：增加函数式接口的概念。“函数式接口”是指仅仅只包含一个抽象方法,但是可以有多个非抽象方法(也就是上面提到的默认方法)的接口。
 * 像这样的接口，可以被隐式转换为lambda表达式。java.lang.Runnable 与 java.util.concurrent.Callable 是函数式接口最典型的两个例子。
 * Java 8增加了一种特殊的注解@FunctionalInterface,但是这个注解通常不是必须的(某些情况建议使用)，只要接口只包含一个抽象方法，
 * 虚拟机会自动判断该接口为函数式接口。一般建议在接口上使用@FunctionalInterface 注解进行声明，这样的话，
 * 编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的
 */
@FunctionalInterface
public interface FuncInter<F, T> {
    T f(F from);

}
