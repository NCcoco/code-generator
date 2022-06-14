package ${packagePath}.service;

<#assign ClassName = "${className?substring(0, 1)?upper_case}${className?substring(1)}"/>
<#assign className = "${className?substring(0, 1)?lower_case}${className?substring(1)}" />
import ${packagePath}.bean.${ClassName};
import ${packagePath}.dao.${ClassName}Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Example;

import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.REQUIRES_NEW;
import static javax.transaction.Transactional.TxType.MANDATORY;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;
import static javax.transaction.Transactional.TxType.NEVER;

import java.util.List;

@Service
public class ${ClassName}Service {

    <#assign daoName = "${className}Dao" />
    @Autowired
    private ${ClassName}Dao ${daoName};

    @Transactional(value = REQUIRED, rollbackOn = Exception.class)
    public ${ClassName} add(${ClassName} ${className}) {
        Assert.notNull(${className}, "${className}不能为空");
        ${className}.setCreateTime(LocalDateTime.now());
        ${className}.setIsDelete(false);
        return ${daoName}.save(${className});
    }

    public ${ClassName} findById(${keyFieldType} ${keyFieldName}) {
        Assert.notNull(${keyFieldName}, "${keyFieldName}不能为空");
        ${ClassName} ${className} = new ${ClassName}();
        ${className}.setIsDelete(false);
        ${className}.setId(${keyFieldName});
        Example<${ClassName}> example = Example.of(${className});
        return ${daoName}.findAll(example);
    }

    public List<${ClassName}> findAll() {
        ${ClassName} ${className} = new ${ClassName}();
        ${className}.setIsDelete(false);
        Example<${ClassName}> example = Example.of(${className});
        return ${daoName}.findAll(example);
    }

    public List<${ClassName}> findByCustomCondition(${ClassName} ${className}) {
        ${className}.setIsDelete(false);
        Example<${ClassName}> example = Example.of(${className});
        return ${daoName}.findAll(example);
    }

    public Page<${ClassName}> findByCustomCondition(${ClassName} ${className}, Pageable val1) {
        ${className}.setIsDelete(false);
        Example<${ClassName}> example = Example.of(${className});
        return ${daoName}.findAll(example, val1);
    }

    public List<${ClassName}> findByCustomCondition(${ClassName} ${className}, Sort var1) {
        ${className}.setIsDelete(false);
        Example<${ClassName}> example = Example.of(${className});
        return ${daoName}.findByAll(${className}, val1);
    }

    @Transactional(value = REQUIRED, rollbackOn = Exception.class)
    public ${ClassName} update(${ClassName} ${className}) {
        Assert.notNull(${className}, "${className}不能为空");
        Assert.hasText(${className}.getId(), "Id不能为空");
        ${className}.setUpdateTime(LocalDateTime.now());
        return ${daoName}.saveAndFlush(${className});
    }

    @Transactional(value = REQUIRED, rollbackOn = Exception.class)
    public void statusDeleteById(${keyFieldType} ${keyFieldName}) {
        return ${daoName}.statusDeleteById(${keyFieldName});
    }

    @Transactional(value = REQUIRED, rollbackOn = Exception.class)
    public void deleteById(${keyFieldType} ${keyFieldName}) {
        return ${daoName}.deleteById(${keyFieldName});
    }
}
