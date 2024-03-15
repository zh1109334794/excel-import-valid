package com.eagle.excelvalidation.interfaces.impl;

import com.eagle.excelvalidation.annotations.ExcelLength;
import com.eagle.excelvalidation.interfaces.ValidationStrategy;

import java.lang.reflect.Field;

public class LengthValidation implements ValidationStrategy {
    @Override
    public void validate(Object fieldValue, Field field, int rowIndex) throws RuntimeException {
        if (fieldValue instanceof String && fieldValue.toString().length() > field.getAnnotation(ExcelLength.class).max()) {
            throw new RuntimeException("第" + rowIndex + "行数据异常：" + field.getAnnotation(ExcelLength.class).message());
        }
    }
}
