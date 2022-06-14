package com.codegenerator.core.parser;


import com.codegenerator.core.parser.implement.*;

/**
 * 数据解析工厂
 * @auther nc
 */
public class DataParserFactory {
    public static DataParser getDataParser(String parserType) throws Exception {
        if (parserType.equals("json")) {
            return new JsonDataParser();
        } else if (parserType.equals("xml")) {
            return new XmlDataParser();
        } else if (parserType.equals("csv")) {
            return new CsvDataParser();
        } else if (parserType.equals("db-table")) {
            return new DBTableDataParser();
        } else if (parserType.equals("java-class")) {
            return new JavaClassDataParser();
        }
        throw new Exception("不支持的数据解析类型");
    }
}
