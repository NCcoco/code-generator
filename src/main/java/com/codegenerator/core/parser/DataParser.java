package com.codegenerator.core.parser;

import com.codegenerator.core.FieldInfo;
import com.codegenerator.core.bean.BaseBeanGeneratorInfo;

import java.util.List;
import java.util.Map;

public interface DataParser {
    /**
     * 解析数据 并返回一个map
     *
     * @param data
     * @return
     */
    Map<String, FieldInfo> parseToMap(String data);
}
