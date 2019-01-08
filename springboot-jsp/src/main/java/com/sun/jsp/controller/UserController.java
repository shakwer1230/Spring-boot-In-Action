package com.sun.jsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.jsp.model.User;
import com.sun.jsp.service.UserJPA;
import com.sun.jsp.service.impl.UserService;
import com.sun.jsp.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/20
 * @
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserJPA userJPA;

    @Autowired
    UserService userService;
    //查询
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> list(){
        return userJPA.findAll();
    }

    //添加 更新
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public User save(User user){
        return  userJPA.save(user);
    }
    //删除
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public List<User>delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    public String login(User user, HttpServletRequest request){
        String result="登陆成功";
        boolean flag=true;
        try {
            User validUser=userJPA.findOne(new Specification<User>() {
                @Override
                public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    query.where(cb.equal(root.get("logName"),user.getLogName()));
                    return null;
                }
            });
            if(validUser==null){
                flag=false;
                result="用户不存在，登陆失败";
            }
//            else if(!validUser.getPassWord().equals(user.getPassWord()))
            else if(validUser.getPassWord().equals(null))
            {

                flag=false;
                result="用户密码不相符，登陆失败";
            }
            //登陆成功，写入session
            if(flag!=false){
                request.getSession().setAttribute("_session_user",validUser);
            }

            JSONObject object=new JSONObject();
            object.put("msg","用户："+validUser.getUserName()+","+result);
            request.setAttribute(HttpUtils.LOGGER_RETURN,object);
        }catch (Exception e){
            result="登陆异常："+e.getMessage();
        }

        return  result;
    }


    @RequestMapping(value = "/sendMail",method = RequestMethod.GET)
    public String sendMail(){
        userService.sendMail();
        return "发送成功";
    }


}
