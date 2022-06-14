<#assign StringUtils = statics['com.codegenerator.core.util.StringUtils'] />
package ${packagePath}.bean;

import com.alibaba.fastjson.JSON;
import java.time.LocalDateTime;
<#if isEntity>
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
</#if>

<#assign ClassName = "${className?substring(0, 1)?upper_case}${className?substring(1)}"/>
<#if isEntity>@Entity
@Table(name = "${tableName}")</#if>
public class ${ClassName}<#if superClassName??> extends ${superClassName}</#if><#if interfaceName??> implements ${interfaceName} </#if> {
    <#assign fieldNames = fieldInfoMap?keys />
    <#list fieldNames as fieldName>
        <#assign field = fieldInfoMap[fieldName] />
    <#if field.fieldCommentText??>/** ${field.fieldCommentText} */</#if>
    <#if isEntity><#if (field.fieldIsKey?? && field.fieldIsKey) || fieldName == "id">@Id
    @GenericGenerator(name = "generic_generator", strategy = "uuid")
    @GeneratedValue(generator = "generic_generator")</#if>
    @Column(name = "${StringUtils.camelToUnderline(fieldName)}")</#if>
    private ${field.fieldType} ${fieldName}<#if field.fieldDefaultValue??> = ${field.fieldDefaultValue}</#if>;
    </#list>

    <#list fieldNames as fieldName>
    <#assign field = fieldInfoMap[fieldName] />
    <#assign FieldName = "${fieldName?substring(0, 1)?upper_case}${fieldName?substring(1)}"/>
    public void set${FieldName}(${field.fieldType} ${fieldName}){
        this.${fieldName} = ${fieldName};
    }
    public ${field.fieldType} get${FieldName}(){
        return this.${fieldName};
    }
    </#list>

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}