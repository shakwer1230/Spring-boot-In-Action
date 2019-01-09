package com.sun.jsp.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
public class Inquirer {
    private List<BooleanExpression> expressions;
    public Inquirer(){
        this.expressions=new ArrayList<>();
    }

    public Inquirer putExpression(BooleanExpression expression){
        expressions.add(expression);
        return  this;
    }

    public Predicate buildQuery(){
        BooleanExpression expression=null;
//        for (BooleanExpression ex : expressions) {
//            expression.and();
//        }
        for (int i=0;i<expressions.size();i++){
            if(i==0){
                expression=expressions.get(0);
            }else {
                expression.and(expressions.get(i));
            }
        }
        return  expression;
    }


    public <T>List<T> iteratorToList(Iterable<T>iterable){
        List<T>list=new ArrayList<>();
        Iterator<T> iterator=iterable.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
