package com.codegenerator.controller;

import com.alibaba.fastjson.JSON;
import com.codegenerator.bean.vo.BeanGeneratorVo;
import com.codegenerator.bean.vo.DaoGeneratorVo;
import com.codegenerator.bean.vo.ServiceGeneratorVo;
import com.codegenerator.core.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;

@Api(tags = "代码生成器")
@RestController
@RequestMapping("generate")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @ApiOperation("生成bean代码")
    @GetMapping(value = "bean", produces = "application/octet-stream")
    public void bean(@Valid BeanGeneratorVo vo, HttpServletResponse response) throws Exception {
        System.out.println(JSON.toJSONString(vo));
        String className = vo.getBbgi().getClassName().substring(0, 1).toUpperCase() +
                vo.getBbgi().getClassName().substring(1);
        // 强制将ClassName转换为首字母大写
        vo.getBbgi().setClassName(className);
        File file = File.createTempFile(className, ".java");
        OutputStream os1 = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(os1);
        generatorService.generateBean(vo.getBbgi(), vo.getType(), writer);
        write(className, file, os1, writer, response);
    }

    /**
     * 生成Dao代码
     */
    @ApiOperation("生成Dao代码")
    @GetMapping(value = "dao", produces = "application/octet-stream")
    public void dao(DaoGeneratorVo vo, HttpServletResponse response) throws Exception {
        String className = vo.getBdgi().getClassName().substring(0, 1).toUpperCase()
                + vo.getBdgi().getClassName().substring(1) + "Dao";
        File file = File.createTempFile(className, ".java");
        OutputStream os1 = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(os1);
        generatorService.generateDao(vo.getBdgi(), writer);
        write(className, file, os1, writer, response);
    }

    // 生成一个生成service的方法
    @ApiOperation("生成Service代码")
    @GetMapping(value = "service", produces = "application/octet-stream")
    public void service(ServiceGeneratorVo vo, HttpServletResponse response) throws Exception {
        String className = vo.getBsgi().getClassName().substring(0, 1).toUpperCase()
                + vo.getBsgi().getClassName().substring(1);
        File file = File.createTempFile(className + "Service", ".java");
        OutputStream os1 = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(os1);
        generatorService.generateService(vo.getBsgi(), writer);
        write(className + "Service", file, os1, writer, response);
    }

    // 生成一个生成controller的方法
    


    @ApiOperation("生成Controller代码")
    @GetMapping(value = "controller", produces = "application/octet-stream")
    public void controller(ServiceGeneratorVo vo, HttpServletResponse response) throws Exception {
        String className = vo.getBsgi().getClassName().substring(0, 1).toUpperCase()
                + vo.getBsgi().getClassName().substring(1);
        File file = File.createTempFile(className + "Service", ".java");
        OutputStream os1 = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(os1);
        generatorService.generateService(vo.getBsgi(), writer);
        write(className + "Service", file, os1, writer, response);
    }

    @ApiOperation("生成Vo代码")
    @GetMapping(value = "vo", produces = "application/octet-stream")
    public void vo(ServiceGeneratorVo vo, HttpServletResponse response) throws Exception {
        String className = vo.getBsgi().getClassName().substring(0, 1).toUpperCase()
                + vo.getBsgi().getClassName().substring(1);
        File file = File.createTempFile(className + "Service", ".java");
        OutputStream os1 = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(os1);
        generatorService.generateService(vo.getBsgi(), writer);
        write(className + "Service", file, os1, writer, response);
    }
    

    /**
     * 将文件作为输出流返回客户端
     * 该方法已将各种流关闭
     *
     * @param fileName
     * @param file
     * @param os1
     * @param writer
     * @param response
     * @throws IOException
     */
    private void write(String fileName, File file, OutputStream os1, OutputStreamWriter writer, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".java");
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        InputStream is = new FileInputStream(file);
        int byteRead = -1;
        while ((byteRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, byteRead);
        }
        is.close();
        os.close();
        writer.close();
        os1.close();
    }

}
