package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.User;
import com.service.LoginService;

@Controller
public class UserLogin {
	@Autowired
	LoginService loginServer;
	@ResponseBody
	/*
	 * produces 返回类型编码 解决乱码问题
	 * */
	@RequestMapping(value ="login",produces="application/json; charset=utf-8",method=RequestMethod.POST)
	public String index(HttpServletRequest request,HttpServletResponse response,User user) {
		// 以下代码设置是无效的，以下代码只适用于 response.getOutputStream().write()的情况。
		/*response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		
		boolean staus = loginServer.userLogin(user);
		String LoginStaus = "";
		if(staus) {
			System.out.println("登录成功");
			LoginStaus = "登陆成功";
		}else {
			System.out.println("账号不存在或者密码错误");
			LoginStaus = "登陆失败";
		}
		return LoginStaus;
	}
}
