package com.fufang.ds.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fufang.ds.apiutil.BaseController;
import com.fufang.ds.apiutil.FFApiResponse;
import com.fufang.ds.entity.User;
import com.fufang.ds.service.UserSerivce;

@Controller   
@RequestMapping("user")
public class UserController  extends BaseController{

  @Autowired
  private UserSerivce userSerivce;  
  
  private  HashMap<String, Object>  rsmap= new HashMap<String ,Object>();
  @RequestMapping("/json")  
  @ResponseBody 
  public  FFApiResponse<HashMap <String, Object>>  getTest(){
	  ArrayList <User> list  = new ArrayList<User>();
	  list=userSerivce.selectAll();
	  rsmap.put("rs", list);     
	  return success("1",rsmap);      
  }
  
  
}
