package springboot.example.swagger.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import springboot.example.swagger.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET, path="/list")
	@ResponseBody
	@ApiOperation(value="获取用户列表", notes="获取用户列表")
	public List<User> getUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1, "张三"));
		userList.add(new User(2, "李四"));
		userList.add(new User(3, "王五"));
		return userList;
	}
	
}
