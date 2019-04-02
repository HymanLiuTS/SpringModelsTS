package springmvcdemo.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springmvcdemo.authentication.model.Group;
import springmvcdemo.authentication.model.GroupUserMap;
import springmvcdemo.authentication.model.User;
import springmvcdemo.authentication.service.GroupService;
import springmvcdemo.authentication.service.UserService;
import springmvcdemo.common.domain.Result;
import springmvcdemo.common.repository.GroupRepository;

@Controller
public class AuthController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("groupService")
	private GroupService groupService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Result addUser(@RequestBody User user) {
		Result result = new Result(true, "", null);
		try {
			user = userService.save(user);
			result.setData(user);
		} catch (Exception ex) {
			result.setSucceed(false);
			result.setMsg(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "user";
	}

	@RequestMapping(value = "/group", method = RequestMethod.POST)
	@ResponseBody
	public Result addGroup(@RequestBody Group group) {
		Result result = new Result(true, "", null);
		try {
			group = groupService.save(group);
			result.setData(group);
		} catch (Exception ex) {
			result.setSucceed(false);
			result.setMsg(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/groupusermap" , method = RequestMethod.POST)
	@ResponseBody
	public Result putUserToGroup(String userName,String groupName) {
		Result result=new Result(true,"",null);
		try{
			GroupUserMap map=userService.putUserToGroup(userName, groupName);
			result.setData(map);
		}catch(Exception ex){
			result.setSucceed(false);
			result.setMsg(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/authorities" , method = RequestMethod.GET)
	@ResponseBody
	public Result getAuthorities(Integer id) {
		Result result=new Result(true,"",null);
		try{
			String[] auths=userService.findAllAuthorities(id);
			result.setData(auths);
		}catch(Exception ex){
			result.setSucceed(false);
			result.setMsg(ex.getMessage());
		}
		return result;
	}

}
