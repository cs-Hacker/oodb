package com.cs.oodb.write;

import com.cs.oodb.entity.JsonStruct;
import com.cs.test.entity.Book;
import com.cs.test.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 把对象写成压缩的json字符串
 */
public class ObjectToJson {

    public static Map<String, JsonStruct> DB = new HashMap<String, JsonStruct>();

    //把对象转换成压缩的json字符串
    public static String toCompressJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(obj);

        /**
         * 压缩算法暂时不写
         */

        return json;
    }

    public static boolean addObject(String key, Object obj) throws JsonProcessingException {
        String compressJson = toCompressJson(obj);
        String classPath = obj.getClass().getName();
        JsonStruct jsonStruct = new JsonStruct(compressJson, classPath);

        DB.put("key", jsonStruct);

        return true;
    }



    public static void main(String[] args) throws Exception {

        Book book = new Book("redis设计与实现");
        Student student = new Student(1, "张三", book);

        addObject("student1", student);



        //获得对象




    }



    public Object getObject(String key){
        JsonStruct jsonStruct = DB.get(key);

        //得到json
        String json = toDecompressJson(jsonStruct.getCompressJson());

        //得到Class对象



    }

    public String toDecompressJson(String compressJson){
        String decompressJson = "";


        /**
         * 解压算法暂时不写
         */
        decompressJson = compressJson;


        return decompressJson;
    }


}
