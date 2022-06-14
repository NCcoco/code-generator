package com.codegenerator.core.service;

import com.codegenerator.core.FieldInfo;
import com.codegenerator.core.Generator;
import com.codegenerator.core.bean.BaseBeanGeneratorInfo;
import com.codegenerator.core.bean.BaseDaoGeneratorInfo;
import com.codegenerator.core.bean.BaseServiceGeneratorInfo;
import com.codegenerator.core.bean.GeneratorInfo;
import com.codegenerator.core.parser.DataParser;
import com.codegenerator.core.parser.DataParserFactory;
import com.codegenerator.core.util.StringUtils;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorService {

    @Autowired
    private Generator generator;

    /**
     * 生成bean代码
     * @param bbgi
     * @param writer
     * @throws Exception
     */
    public void generateBean(BaseBeanGeneratorInfo bbgi, String type, Writer writer) throws Exception {
        Assert.notNull(bbgi, "BaseBeanGeneratorInfo不能为空");
        DataParser dataParser = DataParserFactory.getDataParser(type);
        Map<String, FieldInfo> fieldInfoMap = dataParser.parseToMap(bbgi.getFieldInfoJsonString());
        if (bbgi.getEntity()) {
            bbgi.setTableName("t_" + StringUtils.camelToUnderline(bbgi.getClassName()));
        }
        List<FieldInfo> defaultFieldList = getDefaultFieldList();
        // 如果没有key，则填充一个id
        if (!bbgi.getHasKey() && fieldInfoMap.get("id") == null) {
            fieldInfoMap.put("id", defaultFieldList.get(0));
        }
        // 填充其他默认字段
        for (int i = 1; i < defaultFieldList.size(); i ++) {
            fieldInfoMap.put(defaultFieldList.get(i).getFieldName(), defaultFieldList.get(i));
        }
        GeneratorInfo info = bbgi;
        Map<String, Object> data = new HashMap<>(50);
        buildMapByGeneratorInfo(data, info);
        data.put("fieldInfoMap", fieldInfoMap);
        BeansWrapper wrapper = new BeansWrapper(Configuration.VERSION_2_3_23);
        TemplateModel statics = wrapper.getStaticModels();
        data.put("statics", statics);
        generator.generate(data, "bean", writer);
    }

    /**
     * 生成dao代码
     */
    public void generateDao(BaseDaoGeneratorInfo bdgi, OutputStreamWriter writer) throws IllegalAccessException, TemplateException, IOException {
        Map<String, Object> data = new HashMap<>(50);
        buildMapByGeneratorInfo( data , bdgi);
        generator.generate(data, "dao", writer);
    }


    public void generateService(BaseServiceGeneratorInfo bsgi, OutputStreamWriter writer) throws TemplateException, IOException, IllegalAccessException {
        Map<String, Object> data = new HashMap<>(50);
        buildMapByGeneratorInfo(data , bsgi);
        generator.generate(data, "service", writer);
    }

    private void buildMapByGeneratorInfo(Map<String, Object> data , GeneratorInfo info) throws IllegalAccessException {
        Class<? extends GeneratorInfo> clz = info.getClass();
        for (Field field : clz.getDeclaredFields()) {
            field.setAccessible(true);
            data.put(field.getName(), field.get(info));
            field.setAccessible(false);
        }
    }

    /**
     * 填充必要的字段信息
     * @return
     */
    private List<FieldInfo> getDefaultFieldList() {
        List<FieldInfo> fields = new ArrayList<>();
        // ID字段
        FieldInfo id = new FieldInfo();
        id.setFieldName("id");
        id.setFieldType("String");
        id.setFieldCommentText("主键");
        id.setFieldIsKey(true);
        id.setFieldIsForeignKey(false);
        fields.add(id);
        // 状态字段
        FieldInfo status = new FieldInfo();
        status.setFieldName("status");
        status.setFieldType("Integer");
        status.setFieldCommentText("状态");
        status.setFieldIsKey(false);
        status.setFieldIsForeignKey(false);
        fields.add(status);
        // 创建时间字段
        FieldInfo createTime = new FieldInfo();
        createTime.setFieldName("createTime");
        createTime.setFieldType("LocalDateTime");
        createTime.setFieldCommentText("创建时间");
        createTime.setFieldIsKey(false);
        createTime.setFieldIsForeignKey(false);
        fields.add(createTime);
        // 更新时间字段
        FieldInfo updateTime = new FieldInfo();
        updateTime.setFieldName("updateTime");
        updateTime.setFieldType("LocalDateTime");
        updateTime.setFieldCommentText("更新时间");
        updateTime.setFieldIsKey(false);
        updateTime.setFieldIsForeignKey(false);
        fields.add(updateTime);
        // 是否删除字段
        FieldInfo isDelete = new FieldInfo();
        isDelete.setFieldName("isDelete");
        isDelete.setFieldType("Boolean");
        isDelete.setFieldCommentText("是否删除");
        isDelete.setFieldIsKey(false);
        isDelete.setFieldIsForeignKey(false);
        fields.add(isDelete);

        return fields;
    }

}
