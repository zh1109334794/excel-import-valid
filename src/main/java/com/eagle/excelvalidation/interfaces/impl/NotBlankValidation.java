package com.eagle.excelvalidation.interfaces.impl;

import com.eagle.excelvalidation.annotations.ExcelNotBlank;
import com.eagle.excelvalidation.interfaces.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.Objects;

public class NotBlankValidation implements ValidationStrategy {
    @Override
    public void validate(Object fieldValue, Field field, int rowIndex) throws RuntimeException {
        if (Objects.isNull(fieldValue) || (fieldValue instanceof String && ((String) fieldValue).length() == 0)) {
            throw new RuntimeException("第" + rowIndex + "行数据异常：" + field.getAnnotation(ExcelNotBlank.class).message());
        }
    }
}
