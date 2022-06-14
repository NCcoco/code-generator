package com.codegenerator.core.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 生成dao所需的基础信息
 * @author nc
 */
public class BaseDaoGeneratorInfo implements GeneratorInfo {

    private String className;

    private String keyFieldName;

    private String keyFieldType;

    private String interfaceName;

    private String superClassName;

    private String packagePath;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getKeyFieldName() {
        return keyFieldName;
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }

    public String getKeyFieldType() {
        return keyFieldType;
    }

    public void setKeyFieldType(String keyFieldType) {
        this.keyFieldType = keyFieldType;
    }

    @Override
    public String getInterfaceName() {
        return interfaceName;
    }

    @Override
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public String getSuperClassName() {
        return superClassName;
    }

    @Override
    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    @Override
    public String getPackagePath() {
        return packagePath;
    }

    @Override
    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
