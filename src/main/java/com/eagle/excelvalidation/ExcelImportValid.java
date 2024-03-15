package com.eagle.excelvalidation;

import com.eagle.excelvalidation.factory.ValidationFactory;
import com.eagle.excelvalidation.interfaces.ValidationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author zhouhan
 * @date 2024-03-12 15:55:14
 * @description 对注解的字段进行校验
 */
public class ExcelImportValid {
    /**
     * Excel导入字段校验
     *
     * @param object 校验的JavaBean 其属性须有自定义注解
     */
    public static void valid(Object object,Integer rowIndex)  {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            //设置可访问
            field.setAccessible(true);
            //属性的值
            Object fieldValue;
            try {
                fieldValue = field.get(object);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("获取参数失败失败");
            }
            //进行校验
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation:annotations){
                ValidationStrategy strategy = ValidationFactory.getValidationStrategy(annotation);
                if (strategy != null) {
                    strategy.validate(fieldValue, field, rowIndex);
                }
            }
        }
    }

    public static void preHandle(Object object,Integer rowIndex){
        valid(object,rowIndex);
    }

}
