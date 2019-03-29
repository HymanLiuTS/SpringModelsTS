package springmvcdemo.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springmvcdemo.authentication.model.User;
import springmvcdemo.authentication.service.UserService;
import springmvcdemo.common.domain.Result;

@Controller
public class AuthController {
	
	@Autowired
	@Qualifier("userService")
    private UserService userService;
	
	@RequestMapping(value = "/user" , method = RequestMethod.POST)
	@ResponseBody
	public Result addUser(@RequestBody User user) {
		Result result=new Result(true,"",null);
		try{
			user=userService.addUser(user);
			result.setData(user);
		}catch(Exception ex){
			result.setSucceed(false);
			result.setMsg(ex.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public String user() {
		return "user";
	}

}
