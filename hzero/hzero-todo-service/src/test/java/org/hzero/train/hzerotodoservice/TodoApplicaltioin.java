package org.hzero.train.hzerotodoservice;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jmx
 * @Date:created in 2019/7/31
 * @Description:  测试TodoApplication
 */
@RestController
@EnableChoerodonResourceServer
@SpringBootApplication
public class TodoApplicaltioin {
     public static void main(String args[]){
         SpringApplication.run(TodoApplication.class);
     }
     @GetMapping
     @Permission(level= ResourceLevel.SITE,permissionPublic = true)
     @ApiOperation(value="demo")
     public ResponseEntity<String> hello(){
         return new ResponseEntity<String>("hzero hello", HttpStatus.OK);
     }
}
