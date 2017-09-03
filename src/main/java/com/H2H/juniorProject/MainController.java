package com.H2H.juniorProject;


import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.annotation.PostConstruct;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ibatis.common.jdbc.ScriptRunner;



@Controller
public class MainController {
	

	  @PostConstruct
    public void init() {
		try {
			SqlRunner.main(null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	    
	ApplicationContext context =
		new ClassPathXmlApplicationContext("Spring-Module.xml");
	UserDao userDao = (UserDao) context.getBean("userDao");
	LocationDao locationDao = (LocationDao) context.getBean("locationDao");
	Logger  logger = (Logger) context.getBean("logger");
	Log tempLog  = new Log();
	User loggedUser;
	
	public String init(Model model) {
	    model.addAttribute("msg", "id sifre gir");
	    return "login";
	}
   @RequestMapping(value = "/", method = RequestMethod.GET)
  	public String initHome(Model model) {
	  if(loggedUser==null) return "login";
	  model.addAttribute("msg", "giriş yapılan hesap : "+ loggedUser.getUsername()+" id:"+loggedUser.getId());
	   model.addAttribute("locations",locationDao.getLocation());
	   model.addAttribute("users",userDao.getUser());
	   model.addAttribute("logs",logger.getLog(tempLog));
	  
	   model.addAttribute("loggedUser",loggedUser);
	   openMenu1(model);
	   
//	   if(loggedUser!=null)
//  	    model.addAttribute("durum", new HavaDurumu("Istanbul"));
//	 
//	   else
//		   model.addAttribute("msg","Giris Yapiniz");
  	    return "home";
  	}
   //Menu
	public void openMenu1(Model model){
	 model.addAttribute("menu","menu1");
	}
	public void openMenu2(Model model){
	  	 model.addAttribute("menu","menu2");
	  	}
	public void openMenu3(Model model){
	  	 model.addAttribute("menu","menu3");
	  	}
	public void openMenu4(Model model){
  	      	 model.addAttribute("menu","menu4");
  	      	}
	 //USER 
	@RequestMapping(value = "/User",params="add",method = RequestMethod.POST)	
	public String add(Model model, @ModelAttribute("userBean") User userBean) {

	
   
	    	if(userBean!=null){
	    		
	    		if(userDao.insert(userBean));
		    	model.addAttribute("users",  userDao.getUser());
		    	initHome(model);
		    	openMenu3(model);
		    	}
   	return "home";
}
	@RequestMapping(value = "/User",params = "del",method = RequestMethod.POST)	   
   	public String delete(Model model, @ModelAttribute("userBean") User userBean) {
	   	if(userBean!=null){
	   		if(userBean.getId()!=1){
	   		userDao.delete(userBean.getId());}
	   		openMenu3(model);
	   	}
	   	return initHome(model);
	   }

	 @RequestMapping(value = "/User",params = "details",method = RequestMethod.POST)
	public String details(Model model, @ModelAttribute("userBean") User userBean,@RequestParam String details) {
	    	if(userBean!=null){
	    		model.addAttribute("user",userBean);
				return "userDetail";
	    	}else{
	    		openMenu3(model);
	    		return "home";
	    	}
	}
   @RequestMapping(value = "/User",params = "update",method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("userBean") User userBean) {
	   
	   		if(userBean!=null||true){
	   			if(userBean.getId()!=1)
	   				userDao.update(userBean);
	   			model.addAttribute("msg","id = "+userBean.getId()+" olan user güncellendi.");
				return initHome(model);
	   		}else{
	   			model.addAttribute("msg","lutfen yer girin");

	     
	   		}
	   	
	   	return "home";
	}

  //LOCATION
	@ModelAttribute("locationBean")
	public Location getLocationBean(){
	    return new Location();
	}
	@ModelAttribute("logBean")
	public Log getLogBean(){
	    return new Log();
	}


	@RequestMapping(value = "/Location",params = "add",method = RequestMethod.POST)	   
	public String add(Model model, @ModelAttribute("locationBean") Location locationBean) {
   	if(locationBean!=null){
   		if(locationDao.insert(locationBean));

   		locationBean = null;
   		initHome(model);
   		openMenu1(model);
   		}
   		return "home";
	}
	@RequestMapping(value = "/Location",params = "del",method = RequestMethod.POST)	   
	public String delete(Model model, @ModelAttribute("locationBean") Location locationBean) {
   	if(locationBean!=null){
   		locationDao.delete(locationBean.getId());
   		initHome(model);
   		openMenu1(model);
   	}
   	return "home";
   }
	 @RequestMapping(value = "/Location",params = "details",method = RequestMethod.POST)
    public String details(Model model, @ModelAttribute("locationBean") Location locationBean,@RequestParam String details) {
	    	if(locationBean!=null){
	    		model.addAttribute("location",locationBean);
				return "locationDetail";
	    	}else{
	    		return "home";
	    	}
	}
   @RequestMapping(value = "/Location",params = "update",method = RequestMethod.POST)
   	public String update(Model model, @ModelAttribute("locationBean") Location locationBean) {
   	if(locationBean!=null){
   		if(locationBean.getLocationName()!=""){
   			
   		locationDao.update(locationBean);
   		model.addAttribute("msg","id = "+locationBean.getId()+" olan user güncellendi.");
			return initHome(model);
   		}else{
   			model.addAttribute("msg","lutfen yer girin");

       		return "home";
   		}
   	}else{

   		model.addAttribute("location",locationBean);
   		return "home";
   	}
   	
}
   //Query weather
	@RequestMapping(value = "/Location",params = "query",method = RequestMethod.POST)	   
	public String query(Model model,HttpServletRequest request, @ModelAttribute("locationBean") Location locationBean) {
	   long startTime = System.nanoTime();
	   	if(locationBean!=null){
	   		System.out.println(locationBean.getId());

	   		System.out.println(locationDao.getLocation(locationBean.getId()));
	   	HavaDurumu	result =new HavaDurumu(locationDao.getLocation(locationBean.getId()).getLocationName());
	   		model.addAttribute("queryResult",result);
	 	   long endTime = System.nanoTime();
	 	   long duration = (endTime - startTime) / 1000000; 
	 	   logger.insert(new Log(loggedUser.getId(),locationBean.getId(),new Timestamp(System.currentTimeMillis()),request.getRemoteAddr(),duration,result.getResult()));
	   		locationBean = null;
	   		initHome(model);
	   		openMenu2(model);
	   		}
	   		return "home";
		}
   
   //Log
	@RequestMapping(value = "/Log",params = "query",method = RequestMethod.POST)	   
	public String query(Model model, @ModelAttribute("logBean") Log logBean) {
  	if(logBean!=null){
  		tempLog = logBean;
  		initHome(model);
  		openMenu4(model);
  		
  		}
  		return "home";
	}

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	 @RequestMapping(params = "logOut",method = RequestMethod.POST)
		public String details(Model model) {
		 loggedUser=null;
		 return "login";
	 }
		
   
   
   
   
   
   
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(Model model, @ModelAttribute("loginBean") User loginBean){
		
    	UserDao loginDao = (UserDao) context.getBean("userDao");
    	if(loginBean== null){
    		model.addAttribute("error", "boş bırakmayınız");
    		return "login";
    	}
    	if (loginBean.getUsername() != "" || loginBean.getPassword() != "") {
    		User userDao=loginDao.getUser(loginBean.getUsername());
    		if(userDao == null){
    			model.addAttribute("error", "hatali kullanıcı adı yada sifre");
    			return "login";
    		}
	    	if(userDao.getPassword().equals(loginBean.getPassword())){
	    		model.addAttribute("loggedUser",loginBean);
	    		loggedUser = userDao;
	    		return initHome(model);
	    	}else{
	    		 model.addAttribute("error", "hatali kullanıcı adı yada sifre");
	                return "login";
	    	}
	    	
	    	
    	
        } else {
            model.addAttribute("error", "Lütfen alanları boş bırakmayınız");
            
            return "login";
        }
    
		
	}
	

}
