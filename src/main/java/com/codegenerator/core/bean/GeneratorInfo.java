package com.codegenerator.core.bean;

public interface GeneratorInfo {

    public String getClassName();

    public void setClassName(String className);

    public String getSuperClassName();

    public void setSuperClassName(String superClassName);

    public String getInterfaceName();

    public void setInterfaceName(String interfaceName);

    public String getPackagePath();

    public void setPackagePath(String packagePath);
}
