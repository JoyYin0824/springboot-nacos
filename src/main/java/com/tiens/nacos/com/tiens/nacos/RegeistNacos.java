package com.tiens.nacos.com.tiens.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class RegeistNacos {

    @NacosInjected
    private NamingService namingService;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 注册服务
     */
    @PostConstruct // 修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次！！！
    public void registerInstance() throws NacosException, UnknownHostException {
        namingService.registerInstance(applicationName, Inet4Address.getLocalHost().getHostAddress(),serverPort);
    }
}
