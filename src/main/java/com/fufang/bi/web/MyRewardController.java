package com.fufang.bi.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fufang.bi.entity.MyReward;
import com.fufang.bi.service.MyRewordService;
import com.fufang.ds.apiutil.BaseController;
import com.fufang.ds.apiutil.FFApiResponse;

@Controller   
@RequestMapping("my")
public class MyRewardController  extends BaseController{

	  @Autowired
	  private MyRewordService myRewordService;  
	  
	  private  HashMap<String, Object>  rsmap= new HashMap<String ,Object>();
	  @RequestMapping("/json")  
	  @ResponseBody 
	  public  FFApiResponse<HashMap <String, Object>>  getTest(){
		  ArrayList <MyReward> list  = new ArrayList<MyReward>();
		  list=myRewordService.selectAll();
		  rsmap.put("rs", list);     
		  return success("1",rsmap);      
	  }
}
