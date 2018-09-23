package cn.wbnull.springbootdemo.controller;

import cn.wbnull.springbootdemo.config.ConfigBeanProp;
import cn.wbnull.springbootdemo.config.ConfigBeanValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 入口类
 *
 * @author dukunbiao(null)  2018-08-18
 *         https://github.com/dkbnull/SpringBootDemo
 */
@RestController
public class GatewayController {

    @Autowired
    private ConfigBeanValue configBeanValue;

    @Autowired
    private Environment environment;

    @Autowired
    private ConfigBeanProp configBeanProp;

    @RequestMapping(value = "/gateway")
    public String gateway() {
        return "Hello World";
    }

    @RequestMapping(value = "/properties")
    public String properties() {
        return "get properties value by ''@Value'' :" +
                //1、使用@Value注解读取
                " name=" + configBeanValue.name +
                " , age=" + configBeanValue.age +
                "<p>get properties value by ''Environment'' :" +
                //2、使用Environment读取
                " sex=" + environment.getProperty("demo.sex") +
                " , address=" + environment.getProperty("demo.address") +
                "<p>get properties value by ''@ConfigurationProperties'' :" +
                //3、使用@ConfigurationProperties注解读取
                " phone=" + configBeanProp.getPhone() +
                " , wife=" + configBeanProp.getWife();
    }
}
