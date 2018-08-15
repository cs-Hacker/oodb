package com.cs.pointUtil;

import com.cs.test.entity.Book;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PointUtil {

    public static boolean isNotNull(String expression, Object obj) throws Exception {
        String[] fieldOrMethodArr = expression.split("\\.");
        if(fieldOrMethodArr.length<2){
            if(obj!=null){
                return true;
            }else{
                return false;
            }
        }

        Class clazz = obj.getClass();
        for(int i=1; i<fieldOrMethodArr.length;i++){
            String fieldOrMethod = fieldOrMethodArr[i];

            if(fieldOrMethod.contains("(") && fieldOrMethod.contains(")")){//方法
                String methodName = fieldOrMethod.substring(0, fieldOrMethod.indexOf("("));

                //如果有参数，直接返回false（目前不支持带参数的方法链判断）
                String paramStr = fieldOrMethod.substring(fieldOrMethod.indexOf("("));
                if(paramStr.length()!=2){
                    return false;
                }

                //根据方法名找不到对应的方法
                Method method = null;
                try {
                    method = clazz.getMethod(methodName);
                }catch (NoSuchMethodException e){
                    return false;
                }

                obj = method.invoke(obj);
                if(obj==null){
                    return false;
                }
                clazz = obj.getClass();

            } else{//属性

                Field field = clazz.getField(fieldOrMethod);
                if(field==null){
                    return false;
                }else{

                    obj = field.get(obj);//获得属性值
                    if(obj==null){
                        return false;
                    }
                    clazz = obj.getClass();

                }

            }



        }

        return true;
    }


    public static void main(String[] args) throws Exception {
        Book book = new Book("java");
        Class clazz = book.getClass();

        Field field = clazz.getField("bookName");
        field.setAccessible(true);
        Object obj = field.get(book);
        System.out.println(obj);



    }







}
