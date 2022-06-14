package com.codegenerator.core;

import com.alibaba.fastjson.JSONObject;
import com.codegenerator.core.bean.GeneratorInfo;
import com.codegenerator.core.parser.DataParser;
import com.codegenerator.core.parser.DataParserFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nc
 */
public class Generator {

    @Autowired
    private Configuration cfg;

    /**
     * 解析数据
     * 因为根据JAVA或数据库表这样的数据，数据属性从提供的信息中获取，所以不需要在这里注入
     * @param data
     * @param type
     * @return
     */
    public Map<String, FieldInfo> parse(String data, String type) throws Exception {
        // 根据type获取数据解析器
        DataParser dataParser = DataParserFactory.getDataParser(type);
        // 解析数据
        return dataParser.parseToMap(data);
    }

    /**
     * 生成代码
     * @param data 生成器所需信息
     * @param modeName 所要生成模块的名称
     * @param writer 输出路径
     */
    public void generate(Map<String, Object> data, String modeName, Writer writer) throws IOException, TemplateException {
        // 获取模板
        Template template = getTemplate(modeName);
        // 生成代码
        template.process(data, writer);
    }

    /**
     * 根据模块名称获取模板
     * @param modeName
     */
    private Template getTemplate(String modeName) throws IOException {
        if (modeName == null || modeName.isEmpty()) {
            return null;
        }
        if (modeName.equals("bean")) {
            return cfg.getTemplate("bean/Bean.ftl");
        } else if (modeName.equals("dao")) {
            return cfg.getTemplate("dao/Dao.ftl");
        } else if (modeName.equals("service")) {
            return cfg.getTemplate("service/Service.ftl");
        } else if (modeName.equals("controller")) {
            return cfg.getTemplate("controller/Controller.ftl");
        }
        return null;
    }

    /**
     *
     */


//    /**
//     * 注入属性
//     * @param fieldInfos
//     *
//     * @return
//     */
//    public void inject(List<FieldInfo> fieldInfos, JSONObject config) {
//        for(FieldInfo fieldInfo : fieldInfos) {
//            FieldInfo injectFieldInfo = config.getObject(fieldInfo.getFieldName(), FieldInfo.class);
//            fieldInfo.setFieldType(injectFieldInfo.getFieldType());
//            fieldInfo.setFieldCommentText(injectFieldInfo.getFieldCommentText());
//            fieldInfo.setFieldDefaultValue(injectFieldInfo.getFieldDefaultValue());
//        }
//    }
}
