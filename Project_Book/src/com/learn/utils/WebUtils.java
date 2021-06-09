package com.learn.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class WebUtils {

     /**
     * 把 Map 中的值注入到对应的 JavaBean 属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            //使用BeanUtils的populate方法，将前台请求的参数注入到实体类对象中。
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }



     /*
      * @MethodName: 将字符串转换为int类型的字符。
      * @Return:
     **/
    public static int parseInt(String strInt,int defaultValue){
        try {
            if (strInt != null){
                return Integer.parseInt(strInt);
            }else{
                return defaultValue ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
