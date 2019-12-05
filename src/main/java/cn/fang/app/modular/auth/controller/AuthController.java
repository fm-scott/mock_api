package cn.fang.app.modular.auth.controller;

import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itmuch.lightsecurity.jwt.JwtOperator;
import com.itmuch.lightsecurity.jwt.User;
import com.itmuch.lightsecurity.jwt.UserOperator;
import cn.fang.app.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * @ClassName 登陆授权
 * @Author
 * @Date 2019/6/27
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "认证授权模块", tags = "认证授权模块", description = "认证授权模块")
public class AuthController {
	private final UserOperator userOperator;
	private final JwtOperator operator;
	
	/**
	 * 获取当前登录用户信息
	 *
	 * @return 用户信息
	 */
	@GetMapping("/get/user")
	@ApiOperation(value = "获取用户信息", notes = "获取用户信息")
	public User user() {
		return userOperator.getUser();
	}
	
	/**
	 * 小程序登陆，颁发token，暂时模拟openid
	 *
	 * @return token字符串
	 * @Validated @RequestBody LoginVO loginVO
	 */
	@PostMapping("/oauth/access_token")
	@ApiOperation(value = "获取token", notes = "获取token")
	public R<?> loginReturnToken(String userName, String password) {
		if (StringUtils.isBlank(userName)) {
			return R.error(401, "登录账号为空");
		}
		
		if (StringUtils.isBlank(password)) {
			return R.error(401, "登录密码为空");
		}
		// Users loginUser=usersService.loginCheck(userName, password);
		// if(loginUser == null){
		// return R.error(401,"账号密码错误");
		// }
		//
		// List<String> roles=usersService.userRoles(loginUser.getId());
		//
		
		// User user = User.builder()
		// .id(loginUser.getId().intValue())
		// .username(loginUser.getUserName())
		// .roles(roles)
		// .build();
		User user = User.builder().id(1).username("系统管理员").build();
		String token = operator.generateToken(user);
		HashMap<String, String> map = new HashMap<>();
		map.put("access_token", token);
		return R.success(map);
	}
}