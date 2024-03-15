package com.eagle.excelvalidation.interfaces.impl;

import com.eagle.excelvalidation.annotations.ExcelPattern;
import com.eagle.excelvalidation.interfaces.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidation implements ValidationStrategy {
    @Override
    public void validate(Object fieldValue, Field field, int rowIndex) throws RuntimeException {
        if (fieldValue instanceof String) {
            String regex = field.getAnnotation(ExcelPattern.class).regex();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fieldValue.toString());
            if (!matcher.matches()) {
                throw new RuntimeException("第" + rowIndex + "行数据异常：" + field.getAnnotation(ExcelPattern.class).message());
            }
        }
    }
}
