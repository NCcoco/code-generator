package com.codegenerator.bean.vo;

import com.codegenerator.core.bean.BaseDaoGeneratorInfo;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Dao代码生成请求参数
 */
@ApiModel
public class DaoGeneratorVo {
    private BaseDaoGeneratorInfo bdgi;

    public BaseDaoGeneratorInfo getBdgi() {
        return bdgi;
    }

    public void setBdgi(BaseDaoGeneratorInfo bdgi) {
        this.bdgi = bdgi;
    }
}
