package org.cxw.springdemo.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;

/**
 * @description: 配置路由
 * @author: xueWu.Chen
 * @create: 2019-07-31
 **/
@ChoerodonExtraData
public class MyExtraDataManager implements ExtraDataManager {
    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName("ora-todo-25747");
        choerodonRouteData.setPath("/ora-todo-25747/**");
        choerodonRouteData.setServiceId("ora-todo-service-25747");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
