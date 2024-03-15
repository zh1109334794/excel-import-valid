package com.eagle.excelvalidation.interfaces;

import java.lang.reflect.Field;
/**
 * @author zhouhan
 * @date 2024-03-14 11:05:10
 * @description 字段校验接口
 */
public interface ValidationStrategy {
    /** 字段校验方法
    * @Param  fieldValue 属性值
    * @Param  field 属性
    * @Param  rowIndex 在excel中的所在行数
    * @Return void
     */
    void validate(Object fieldValue, Field field, int rowIndex) throws RuntimeException;
}
