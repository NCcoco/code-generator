package com.codegenerator.bean.vo;


import com.codegenerator.core.bean.BaseBeanGeneratorInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Bean代码生成请求参数
 * @author nc
 */
@ApiModel(value = "BeanGeneratorVo", description = "Bean代码生成请求参数")
public class BeanGeneratorVo {
    @ApiModelProperty( required = true)
    private BaseBeanGeneratorInfo bbgi;
    @NotBlank
    private String type;
    @ApiModelProperty( required = true)
    private List<String> templates;

    public BaseBeanGeneratorInfo getBbgi() {
        return bbgi;
    }

    public void setBbgi(BaseBeanGeneratorInfo bbgi) {
        this.bbgi = bbgi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTemplates() {
        return templates;
    }

    public void setTemplates(List<String> templates) {
        this.templates = templates;
    }
}
