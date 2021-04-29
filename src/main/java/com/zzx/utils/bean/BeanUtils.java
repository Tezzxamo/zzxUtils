package com.zzx.utils.bean;

import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * 复制源对象的属性值到目标对象的属性值上
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        Assert.notNull(source, "源对象必须不为null");
        Assert.notNull(source, "目标对象必须不为null");
        Class<?> targetClass = target.getClass();
        // 获取所有的属性
        PropertyDescriptor[] targetPds = getPropertyDescriptors(targetClass);
        for (PropertyDescriptor targetPd : targetPds) {
            // 如果属性的于写入属性值的方法存在
            if (targetPd.getWriteMethod() != null) {
                Method writeMethod = targetPd.getWriteMethod();
                // 根据目标对象的属性名获取源对象的属性名
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                // 源对象不为null，且有get方法
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try{
                        Method readMethod = sourcePd.getReadMethod();
                        // 如果get方法不是public的话,通过反射获取私有变量的值
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())){
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // 判断value是否为null;此处也能进行一些特殊要求的处理,例如绑定时格式转换等等
                        if (value != null){
                            // 获取目标对象写方法的类型
                            Type targetParameterType = writeMethod.getGenericParameterTypes()[0];
                            // 特殊类型不再执行copy XMLGregorianCalendar
                            if (!(targetParameterType.equals(XMLGregorianCalendar.class))){
                                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())){
                                    writeMethod.setAccessible(true);
                                }
                                writeMethod.invoke(target,value);
                            }
                        }
                    }catch (Throwable ex){
                        throw new FatalBeanException("Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }

    /**
     * 集合对象转化赋值
     *
     * @param sources 源集合对象
     * @param voClass vo类型
     * @param <T> 类型
     * @return targets
     */
    public static <T> List<T> copyListProperties(List<? extends Object> sources, final Class<T> voClass) {
        List<T> targets = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return targets;
        }
        for (Object source : sources) {
            if (source == null) {
                continue;
            }
            try {
                T target = voClass.newInstance();
                copyProperties(source, target);
                targets.add(target);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return targets;
    }




}
