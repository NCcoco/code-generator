package com.codegenerator.controller;

import com.codegenerator.bean.ATest;
import com.codegenerator.dao.TestDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试接口")
@RestController
public class TestController {

    @Autowired
    private TestDao testDao;

    @GetMapping()
    public List<ATest> test() {
        ATest t = new ATest();
//        t.setName("张四");
        Example<ATest> example = Example.of(t);
        return testDao.findAll(example);
    }

}
