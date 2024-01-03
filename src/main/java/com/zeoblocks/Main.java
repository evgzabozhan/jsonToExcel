package com.zeoblocks;

import java.io.IOException;

import static com.zeoblocks.JsonFile.jsonMap;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonFile obj = new JsonFile();
        obj.parseData(obj.getDataFromJson("file"));
        ExcelFile file = new ExcelFile();
        file.createFile(jsonMap, "file1");
    }
}