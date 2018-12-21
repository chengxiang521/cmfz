package com.baizhi.cx.controller;

import com.baizhi.cx.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("code")
public class CodeController {
    @RequestMapping("get")
    public void getCode(HttpSession  session, HttpServletResponse response) throws  Exception{
        CreateValidateCode createValidateCode = new CreateValidateCode();
        String code = createValidateCode.getCode();
        session.setAttribute("code",code);
        createValidateCode.write( response.getOutputStream());
    }
    @RequestMapping("validate")
    @ResponseBody
    public String validate(HttpSession  session,String code) {
        String code1 = (String)session.getAttribute("code");
        if (code1.equals(code)){
            return "Y";
        }else{
            return "N";
        }
    }
}
