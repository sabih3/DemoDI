package com.ahmed.sabih.demodi.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;


@Qualifier
@Retention(RetentionPolicy.CLASS.RUNTIME)
public @interface ApplicationContext {

}
