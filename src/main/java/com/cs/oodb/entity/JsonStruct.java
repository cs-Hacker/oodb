package com.cs.oodb.entity;

import lombok.Data;

@Data
public class JsonStruct {

    public String compressJson;
    public String classPath;

    public JsonStruct(String compressJson, String classPath){
        this.compressJson = compressJson;
        this.classPath = classPath;
    }

}
