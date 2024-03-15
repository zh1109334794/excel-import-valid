package com.eagle.excelvalidation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhouhan
 * @date 2024-03-12 16:08:27
 * @description 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 */
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelMin {

     String message() default "{com.eagle.excelvalidation.annotations.ExcelMin.message}";

     long value();

}
