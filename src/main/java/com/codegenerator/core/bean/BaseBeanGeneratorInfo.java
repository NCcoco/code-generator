package com.codegenerator.core.bean;

import com.codegenerator.core.FieldInfo;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

/**
 * @author nc
 */
public class BaseBeanGeneratorInfo implements GeneratorInfo {
    private String className;
    private String superClassName;
    private String interfaceName;
    private String packagePath;
    /** 字段配置信息 */
    @ApiModelProperty( example = "{}", hidden = false, required = true)
    private String fieldInfoJsonString;
    /** 表示是否是一个Entity */
    private Boolean isEntity;
    private Boolean hasKey;
    @ApiModelProperty(hidden = true)
    private String tableName;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getFieldInfoJsonString() {
        return fieldInfoJsonString;
    }

    public void setFieldInfoJsonString(String fieldInfoJsonString) {
        this.fieldInfoJsonString = fieldInfoJsonString;
    }

    public Boolean getEntity() {
        return isEntity;
    }

    public void setEntity(Boolean entity) {
        isEntity = entity;
    }

    public Boolean getHasKey() {
        return hasKey;
    }

    public void setHasKey(Boolean hasKey) {
        this.hasKey = hasKey;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
