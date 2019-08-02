package org.cxw.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @description: 关闭 Spring Security 的安全配置  不需要提交到 git 仓库，只适用于本地测试。
 * @author: xueWu.Chen
 * @create: 2019-07-31
 **/
//@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 禁用 security basic 验证
//        http.httpBasic().disable();
//    }
}
