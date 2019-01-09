package com.sun.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/8
 * @
 */
@Controller
@RequestMapping(value = "upload")
public class UploadController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "upload";
    }

    @RequestMapping(value = "/up",method = RequestMethod.POST)
    public @ResponseBody String upload(HttpServletRequest request,MultipartFile file){
        try {
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir=new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            //上傳文件
            String fileName=file.getOriginalFilename();
            File serverFile=new File(uploadDir+fileName);
            file.transferTo(serverFile);

        }catch (Exception e){
            e.printStackTrace();
            return "上傳失敗";
        }
        return  "上傳成功";
    }
}
