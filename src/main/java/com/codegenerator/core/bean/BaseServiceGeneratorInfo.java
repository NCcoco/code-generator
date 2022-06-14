package com.codegenerator.core.bean;

/**
 *
 * @author nc
 */
public class BaseServiceGeneratorInfo implements GeneratorInfo {
    /** 服务的bean名称 */
    private String className;

    private String packagePath;

    private String keyFieldType;

    private String keyFieldName;

    private String interfaceName;

    private String superClassName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getKeyFieldType() {
        return keyFieldType;
    }

    public void setKeyFieldType(String keyFieldType) {
        this.keyFieldType = keyFieldType;
    }

    public String getKeyFieldName() {
        return keyFieldName;
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
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
}
