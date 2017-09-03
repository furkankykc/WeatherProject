package com.H2H.juniorProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Handles requests for the application home page.
 */


public class HomeController {
	
	
	ApplicationContext context =new ClassPathXmlApplicationContext("Spring-Module.xml");
	UserDao userDao = (UserDao) context.getBean("userDao");
	LocationDao locationDao = (LocationDao) context.getBean("locationDao");
	
	
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
    	
			    	
    	model.addAttribute("users",userDao.getUser());
    	model.addAttribute("locations",locationDao.getLocation());
    							    	

        return "index";	
    }

   
    
    
    @RequestMapping(params="add",method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("userBean") User userBean,@RequestParam String add) {
    	
    	if(userBean!=null){
    		userDao.insert(userBean);
    		model.addAttribute("users",  userDao.getUser());
    	}    	
		return "index";
    	
}
    
    @RequestMapping(params = "del",method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("userBean") User userBean,@RequestParam String del) {

    	if(userBean!=null){
    	userDao.delete(userBean.getId());
    	return "index";
    	}else{
    		return "index";
    	}
}

    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {

    	try{
    	if(request.getParameterValues("userId")!=null)
    	for(String userId : request.getParameterValues("userId")){
    		System.out.println("||||||||||||||||||||||||"+userId+"||||||||||||||||||-");
    		userDao.delete(Integer.parseInt(userId));
    		
    		
    	}
    	}catch(Exception e){
    		modelMap.put("error", e);
    	}
    	modelMap.addAttribute("users",userDao.getClass());
    		return "index";
	    	
	}
	    

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	
}
