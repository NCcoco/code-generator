package com.codegenerator.core.parser.implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codegenerator.core.FieldInfo;
import com.codegenerator.core.parser.DataParser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * json数据解析器
 * @author nc
 */
public class JsonDataParser implements DataParser {

    @Override
    public Map<String, FieldInfo> parseToMap(String data) {
        // 使用fastjson将json字符串转换为fieldInfo对象
        JSONObject jsonObject = JSON.parseObject(data);
        Map<String, FieldInfo> fieldInfoMap = new LinkedHashMap<>(50);
        for(Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            FieldInfo fieldInfo = JSON.parseObject(entry.getValue().toString(), FieldInfo.class);
            fieldInfoMap.put(entry.getKey(), fieldInfo);
        }
        return fieldInfoMap;
    }
}
