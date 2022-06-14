package ${packagePath}.dao;

<#assign ClassName = "${className?substring(0, 1)?upper_case}${className?substring(1)}"/>
<#assign className = "${className?substring(0, 1)?lower_case}${className?substring(1)}"/>
import ${packagePath}.bean.${ClassName};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface ${ClassName}Dao extends JpaRepository<${ClassName}, ${keyFieldType}> {

    @Modifying
    @Query("update ${ClassName} t set t.isDelete = true, t.updateTime = current_timestamp where t.id = :id")
    void statusDeleteById(${keyFieldType} id});
}