package com.sun.jsp.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.sun.jsp.model.Organ;
import com.sun.jsp.model.QOrgan;
import com.sun.jsp.service.Inquirer;
import com.sun.jsp.service.OrganJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
@RestController
@RequestMapping(value = "/organ")
public class OrganController {

    @Autowired
    private OrganJPA organJPA;

    @Autowired
    private EntityManager entityManager;

    //独立QueryDSL查询测试
    @RequestMapping(value = "/list")
    public List<Organ> listOrgan(){
        QOrgan _organ=QOrgan.organ1;
        JPAQuery<Organ> jpaQuery=new JPAQuery<>(entityManager);
        return jpaQuery
                //查詢字段
                .select(_organ)
                //查詢表
                .from(_organ)
                //查詢條件
                .where(_organ.id.eq(Long.valueOf("1")))
                //查詢結果
                .fetch();
    }

    //SpringDataJPA整合QueryDSL
    @RequestMapping(value = "/join",method = RequestMethod.GET)
    public List<Organ> join(){
        //querydsl查詢實體
        QOrgan organ=QOrgan.organ1;

        //查詢條件
        BooleanExpression expression=organ.id.eq(Long.valueOf("1"));
        Iterator<Organ> iterator=organJPA.findAll(expression).iterator();
        List<Organ>organs=new ArrayList<>();

        while (iterator.hasNext()){
            organs.add(iterator.next());
        }
        return organs;
    }

    //自定义查询实体类，该类可以完成查询添加封装，查询结果处理操作，
    @RequestMapping(value = "/joinInquier",method = RequestMethod.GET)
    public List<Organ> joinInquier(){
        //querydsl查詢實體
        QOrgan organ=QOrgan.organ1;

        //查詢條件
        Inquirer inquirer=new Inquirer();
        inquirer.putExpression(organ.id.eq(Long.valueOf("1")));

        return inquirer.iteratorToList(organJPA.findAll(inquirer.buildQuery()));
    }

}
