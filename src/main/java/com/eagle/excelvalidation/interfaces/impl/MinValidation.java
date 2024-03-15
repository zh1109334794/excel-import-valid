package com.eagle.excelvalidation.interfaces.impl;

import com.eagle.excelvalidation.annotations.ExcelMin;
import com.eagle.excelvalidation.interfaces.ValidationStrategy;

import java.lang.reflect.Field;

public class MinValidation implements ValidationStrategy {
    @Override
    public void validate(Object fieldValue, Field field, int rowIndex) throws RuntimeException {
        if (fieldValue instanceof Long && ((Long) fieldValue).longValue() >= field.getAnnotation(ExcelMin.class).value()) {
            throw new RuntimeException("第" + rowIndex + "行数据异常：" + field.getAnnotation(ExcelMin.class).message());
        }
    }
}
