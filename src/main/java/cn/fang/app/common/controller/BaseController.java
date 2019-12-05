package cn.fang.app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.itmuch.lightsecurity.jwt.JwtOperator;
import com.itmuch.lightsecurity.jwt.UserOperator;

import lombok.RequiredArgsConstructor;

/*****
 * *********************************
* @ClassName: BaseController.java
* @Description: 基础控制器
* @author: fangmin
* @createdAt: 2019年9月26日下午2:41:33
**********************************
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseController {
	private final UserOperator userOperator;
    private final JwtOperator operator;
}
