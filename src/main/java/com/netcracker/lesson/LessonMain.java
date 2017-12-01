package com.netcracker.lesson;

import com.netcracker.lesson.annotations.MyAnnotation;
import com.netcracker.lesson.annotations.One;
import com.netcracker.lesson.annotations.Two;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class LessonMain {

    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();

        printAuthor(one);
        printAuthor(two);
    }

    public static void printAuthor(Object o){
        Annotation[] annotations = o.getClass().getAnnotations();
        MyAnnotation myAnnotation = (MyAnnotation) annotations[0];
        System.out.println(myAnnotation.author());
    }




//    public static void main(String[] args) {
//
//        BinaryOperation sum = new BinaryOperation() {
//            @Override
//            public double apply(double a, double b) {
//                return a+b;
//            }
//        };
//
//        BinaryOperation mul = (a,b) -> {
//            return a*b;
//        };
//
//        System.out.println(sum.apply(4,5));
//        System.out.println(mul.apply(4,5));
//    }
}
