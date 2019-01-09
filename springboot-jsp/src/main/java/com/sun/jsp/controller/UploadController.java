package com.sun.jsp.controller;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

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
            execUpload(uploadDir,file);

        }catch (Exception e){
            e.printStackTrace();
            return "上傳失敗";
        }
        return  "上傳成功";
    }

    public Boolean execUpload(String uploadDir,MultipartFile file) throws Exception{
        try {
            //上傳文件
            String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            String fileName= UUID.randomUUID()+suffix;
            File serverFile=new File(uploadDir+fileName);
            file.transferTo(serverFile);
        }catch (Exception e){
            return  false;
        }
        return  true;

    }

    @RequestMapping(value = "/multiUp",method = RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] files){
        String returnStr="";
        String failName="";
        Integer sucIntNum=0;
        try {
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir=new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            for (val file:files
                 ) {
               if(execUpload(uploadDir,file)) {
                   sucIntNum++;
               }else {
                   failName+=file.getName()+" ";
               }
            }
        }catch (Exception e){
            e.printStackTrace();
            return  "上傳失敗";
        }
        returnStr= String.format("上傳%s文件,成功%s個",files.length+"",sucIntNum+"");
        if(files.length!=sucIntNum){
            returnStr+=String.format(",失敗文件%s個，文件名：%s,",files.length-sucIntNum,failName);
        }
        return returnStr;
    }
}
