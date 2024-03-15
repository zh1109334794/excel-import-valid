package com.eagle.excelvalidation.factory;

import com.eagle.excelvalidation.annotations.*;
import com.eagle.excelvalidation.interfaces.ValidationStrategy;
import com.eagle.excelvalidation.interfaces.impl.*;

import java.lang.annotation.Annotation;

public class ValidationFactory {
    public static ValidationStrategy getValidationStrategy(Annotation annotation) {
        if (annotation instanceof ExcelNotNull) {
            return new NotNullValidation();
        } else if (annotation instanceof ExcelNotBlank) {
            return new NotBlankValidation();
        } else if (annotation instanceof ExcelLength) {
            return new LengthValidation();
        } else if (annotation instanceof ExcelMax) {
            return new MaxValidation();
        } else if (annotation instanceof ExcelMin) {
            return new MinValidation();
        } else if (annotation instanceof ExcelPattern) {
            return new PatternValidation();
        }
        // 其他注解类型的判断...
        else {
            return null;
        }
    }
}
