package com.eagle.excelvalidation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhouhan
 * @date 2024-03-12 16:06:49
 * @description 被注释的元素不能为null，可以为空字符串
 */
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelNotBlank {

    String message() default "{com.eagle.excelvalidation.annotations.ExcelNotNull.message}";

}
