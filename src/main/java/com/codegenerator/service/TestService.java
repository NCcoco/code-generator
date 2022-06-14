package com.codegenerator.service;

import com.codegenerator.bean.ATest;
import com.codegenerator.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.REQUIRES_NEW;
import static javax.transaction.Transactional.TxType.MANDATORY;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;
import static javax.transaction.Transactional.TxType.NEVER;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    @Transactional(value= REQUIRED, rollbackOn = Exception.class)
    public void save(ATest test) {
        testDao.save(test);
    }




}
