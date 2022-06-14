package com.codegenerator.dao;

import com.codegenerator.bean.ATest;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao extends JpaRepository<ATest, String> {

    @Query("select t from ATest t where t.id = :#{#test.id}")
    public List<ATest> find(ATest test);

    @Modifying()
    @Query("update ATest t set t.name = :#{#test.name} where t.id = :#{#test.id}")
    public void delete(ATest test);

    @Override
    <S extends ATest> List<S> findAll(Example<S> example);
}
