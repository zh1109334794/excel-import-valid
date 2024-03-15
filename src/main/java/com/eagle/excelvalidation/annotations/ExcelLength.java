package com.eagle.excelvalidation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author zhouhan
 * @date 2024-03-12 16:08:27
 * @description 被注释的字符串的大小必须在指定的范围内
 */
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelLength {

     String message() default "{com.eagle.excelvalidation.annotations.ExcelLength.message}";

     int min() default 0;

     int max() default Integer.MAX_VALUE;

}
