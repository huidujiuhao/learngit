package org.cxw.springdemo.api.controller.v1;


import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.concurrent.Task;
import org.cxw.springdemo.app.service.UserService;
import org.cxw.springdemo.config.SwaggerApiConfig;
import org.cxw.springdemo.domain.entity.User;
import org.cxw.springdemo.domain.repository.UserRepository;
import org.hzero.core.base.BaseController;
import org.hzero.core.base.Result;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 用户应用展现层
 * @author: xueWu.Chen
 * @create: 2019-07-31
 **/
@Api(tags= SwaggerApiConfig.USER)
@RestController("userController.v1")
@RequestMapping("/v1/users")
public class UserController extends BaseController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,UserRepository userRepository){
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询用户")
    @GetMapping
    public ResponseEntity<Page<User>> pageTask(User user, PageRequest pageRequest){
        return Results.success(userRepository.pageAndSort(pageRequest,user));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "创建todo用户")
    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody User user){
        //简单数据校验
        this.validObject(user);
        //创建用户
        return Results.success(userService.create(user));
    }
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "删除 todo 用户")
    @DeleteMapping
    private ResponseEntity<User> deleteUser(@RequestBody User user) {
        // 数据防篡改校验
        SecurityTokenHelper.validToken(user);
        // 删除用户
        userService.delete(user.getId());
        return Results.success();
    }
}
