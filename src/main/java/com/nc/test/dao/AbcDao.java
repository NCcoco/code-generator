package com.nc.test.dao;

import com.nc.test.bean.Abc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@Repository
public interface AbcDao extends JpaRepository<Abc, String> {
    @Query("select t from Abc t where 1=1" +
    " and t.hOffset = :#{#abc.hOffset} " +
    " and t.src = :#{#abc.src} " +
    " and t.name like :#{#abc.name} " +
    "")
    List<Abc> findByCustomCondition(Abc abc);

    @Query("select t from Abc t where 1=1" +
    " and t.hOffset = :#{#abc.hOffset} " +
    " and t.src = :#{#abc.src} " +
    " and t.name like :#{#abc.name} " +
    "")
    Page<Abc> findByCustomCondition(Abc abc, Pageable val1);

    @Query("select t from Abc t where 1=1" +
    " and t.hOffset = :#{#abc.hOffset} " +
    " and t.src = :#{#abc.src} " +
    " and t.name like :#{#abc.name} " +
    "")
    List<Abc> findByCustomCondition(Abc abc, Sort var1);

    @Query("select t from Abc t where 1=1" +
    " and t.hOffset = :#{#abc.hOffset} " +
    " and t.src = :#{#abc.src} " +
    " and t.name like :#{#abc.name} " +
    "")
    Page<Abc> findByCustomCondition(Abc abc, Pageable val1, Sort var2);
}