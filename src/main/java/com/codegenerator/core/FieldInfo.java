package com.codegenerator.core;

/**
 * 字段信息类
 * @author nc
 */
public class FieldInfo {
    /** 字段名 */
    private String fieldName;
    /** 字段类型 */
    private String fieldType;
    /** 字段注释 */
    private String fieldCommentText;
    /** 字段长度 */
    private String fieldLength;
    /** 字段默认值 */
    private String fieldDefaultValue;
    /** 字段是否为Key */
    private Boolean fieldIsKey;
    /** 字段是否为外键 */
    private Boolean fieldIsForeignKey;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldCommentText() {
        return fieldCommentText;
    }

    public void setFieldCommentText(String fieldCommentText) {
        this.fieldCommentText = fieldCommentText;
    }

    public String getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldDefaultValue() {
        return fieldDefaultValue;
    }

    public void setFieldDefaultValue(String fieldDefaultValue) {
        this.fieldDefaultValue = fieldDefaultValue;
    }

    public Boolean getFieldIsKey() {
        return fieldIsKey;
    }

    public void setFieldIsKey(Boolean fieldIsKey) {
        this.fieldIsKey = fieldIsKey;
    }

    public Boolean getFieldIsForeignKey() {
        return fieldIsForeignKey;
    }

    public void setFieldIsForeignKey(Boolean fieldIsForeignKey) {
        this.fieldIsForeignKey = fieldIsForeignKey;
    }
}
