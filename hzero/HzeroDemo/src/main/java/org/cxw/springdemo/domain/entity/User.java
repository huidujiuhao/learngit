package org.cxw.springdemo.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hzero.core.util.Regexs;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import sun.misc.Regexp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @description: 用户实体类
 * @author: xueWu.Chen
 * @create: 2019-07-30
 **/
@Table(name = "todo_user")
@ModifyAudit  //在类上使用，启用审计字段支持，实体类加上该注释后，插入和更新或启动
                //对lastUpdateDate 和lastUpdatedBy自维护字段支持
@ApiModel("用户信息")   //Swagger  实体描述
@VersionAudit //在类上使用，启用objectVersionNumber自维护支持，插入一条数据objectVersionNumber默认为1，每次update后objectVersionNumber自增1
@JsonInclude(JsonInclude.Include.NON_NULL) //数据返回前段时。排除为空的字段
public class User extends AuditDomain {
    @Id //注解主键
    @GeneratedValue //对于自增长，序列类型的主键，需要添加该注解
    private Long id;
    @Length(max = 30)
    @NotBlank   // 非空控制
    @ApiModelProperty("员工姓名")   //Swagger字段描述
    private String employeeName;
    @Length(max = 30)
    @NotBlank
    @Pattern(regexp = Regexs.CODE,message = "htdo.warn.numberFormatIncorrect")
    //格式控制
    @ApiModelProperty("员工编号")
    private String employeeNumber;
    @Length(max = 60)
    @Pattern(regexp = Regexs.EMAIL,message = "htdo.warn.emailFormatIncorrect")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
