package com.hello.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Greets you in a based on style from http://www.imdb.com/title/tt0904208/
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@GreetingAnnotation
public @interface CalifornicationWay {
}
