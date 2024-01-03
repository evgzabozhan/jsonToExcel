package com.zeoblocks;

import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonFile {

    public static Map<String, FileData> jsonMap = new LinkedHashMap<>();


    public void parseData(String data) {
        JSONObject obj = new JSONObject(data);
        jsonCreateMap(obj,"");
        show();
    }

    public String getDataFromJson(String fileName) throws IOException {
        return Files.readString(Paths.get("src/main/resources/" + fileName + ".json"));
    }

    public void jsonCreateMap(JSONObject obj, String inputPath) {
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String path;
            if (inputPath.isEmpty()) {
                path = key;
            } else {
                path = inputPath + "." + key;
            }
            jsonMap.put(path, new FileData(path, "yes", getType(obj.get(key)), getFormat(obj.get(key))));
            if (obj.get(key) instanceof JSONObject) {
                jsonCreateMap((JSONObject) obj.get(key), path);
            } else if (obj.get(key) instanceof JSONArray) {
                JSONArray array = obj.getJSONArray(key);
                for (Object o : array) {
                    jsonCreateMap((JSONObject) o, path);
                }
            }
        }
    }


    public String getType(Object value) {
        if (value instanceof Integer) {
            return "number";
        } else if (value instanceof Double) {
            return "number";
        } else if (value instanceof String) {
            return "string";
        } else if (value instanceof Boolean) {
            return "boolean";
        } else if (value instanceof JSONObject) {
            return "object";
        } else if (value instanceof JSONArray) {
            return "array";
        } else if (Objects.isNull(value)) {
            return "null";
        } else {
            return "unknown format";
        }
    }

    public String getFormat(Object value) {
        if (value instanceof Double) {
            return String.valueOf(value);
        } else if (value instanceof Integer) {
            return String.valueOf(value);
        } else if (value instanceof String) {
            return String.valueOf(value);
        } else if (value instanceof Boolean) {
            return String.valueOf(value);
        } else {
            return " ";
        }
    }

    public void show() {
        for (Map.Entry<String, FileData> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}


