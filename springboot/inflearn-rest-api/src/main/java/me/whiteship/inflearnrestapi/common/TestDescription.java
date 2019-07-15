package me.whiteship.inflearnrestapi.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE) // 얼마나 오래 가져갈건
public @interface TestDescription {
    String value();
}
