package ${packagePath}.controller.vo;

import javax.validation.constraints.NotBlank;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ${VoClassName} {

    <#assign fieldNames = fieldInfoMap?keys />
    <#list fieldNames as fieldName>
    <#assign field = fieldInfoMap[fieldName] />
    <#if field.fieldCommentText??>/** ${field.fieldCommentText} */</#if>
    <#if !field.nullable and field.fieldType == "String">@NotBlank</#if>
    private ${field.fieldType} ${field.fieldName};
    </#list>

    <#list fieldNames as fieldName>
    <#assign field = fieldInfoMap[fieldName] />
    <#assign FieldName = "${fieldName?substring(0, 1)?upper_case}${fieldName?substring(1)}"/>
    public void set${FieldName}(${field.fieldType} ${fieldName}) {
        this.${fieldName} = ${fieldName};
    }
    public ${field.fieldType} get${FieldName}() {
        return this.${fieldName};
    }
    </#list>

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}