package com.codegenerator.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

<#assign ControllerClassName = "${ClassName}Controller" />
@Api(tags = "${ClassName}控制器")
@Controller
@RequestMapping(value = "${requestMapping}")
public class ${ControllerClassName} {

    @Autowired
    private ${ClassName}Service ${className}Service;

    @ApiOperation("新增${ClassName}")
    @PostMapping(value = "add")
    public void add(@Valid ${AddVoClassName} param) {
        ${ClassName} ${className} = new ${ClassName}();
        BeanUtils.copyProperties(param, ${className});
        ${className}Service.add(${className});
    }

    @ApiOperation("查询${ClassName}")
    @PostMapping(value = "query")
    public void query(@Valid ${QueryVoClassName} param) {
        ${ClassName} ${className} = new ${ClassName}();
        BeanUtils.copyProperties(param, ${className});
        ${className}Service.findByCustomCondition(${className});
    }

    @ApiOperation("可翻页查询${ClassName}")
    @PostMapping(value = "query/paging")
    public void query(@Valid ${QueryPagingVoClassName} param) {
        ${ClassName} ${className} = new ${ClassName}();
        BeanUtils.copyProperties(param, ${className});
        ${className}Service.findByCustomCondition(${className}, param.getPaging());
    }

    @ApiOperation("更新${ClassName}")
    @PostMapping(value = "update")
    public void update(${VoClassName} param) {
        ${ClassName} ${className} = new ${ClassName}();
        BeanUtils.copyProperties(param, ${className});
        ${className}Service.add(${className});
    }

    @ApiOperation("状态上删除${ClassName}")
    @PostMapping(value = "status/delete")
    public void statusDelete(String id) {
        ${className}Service.statusDeleteById(id);
    }

    @ApiOperation("物理删除${ClassName}")
    @PostMapping(value = "physics/delete")
    public void physicsDelete(@Valid String id) {
        ${className}Service.deleteById(id);
    }
}
