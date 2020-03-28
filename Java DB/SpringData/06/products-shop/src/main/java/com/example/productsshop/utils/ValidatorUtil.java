package com.example.productsshop.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidatorUtil {

    <T> boolean isValid(T entity);

    <T>Set<ConstraintViolation<T>> getViolations(T entity);
}
