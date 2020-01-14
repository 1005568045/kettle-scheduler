package com.wh.kettlescheduler.shiro.config;

import com.wh.kettlescheduler.shiro.realm.MyShiroRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Shiro的安全管理器初始化
 *
 * @author lyf
 */
@Slf4j
@Configuration
public class MyShiroConfig {

    /**
     * 为了保证实现了Shiro内部lifecycle函数的bean执行,也是shiro的生命周期
     * 需要手动注册生命周期的后置管理器
     *
     * @return {@link LifecycleBeanPostProcessor}
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 在引入spring aop的情况下。
     * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，
     * 导致返回404。加入这项配置能解决这个bug，主要是解决 JDK 动态代理问题，需要指定成 CGLIB 代理方式
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 手动注册自定义realm对象到spring中, 否则globalSecurityManager绑定Realm会失败
     *
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    /**
     * 全局安全管理器配置
     * 绑定Realm数据对象
     * 绑定自定义session会话管理
     * 绑定自定义缓存实现
     *
     * @return {@link DefaultWebSecurityManager}
     */
    @Bean
    public DefaultWebSecurityManager globalSecurityManager(MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(myShiroRealm);
        return webSecurityManager;
    }

    /**
     * 对shiro的过滤进行设置
     *
     * @return {@link ShiroFilterChainDefinition}
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        // 可以匿名访问静态资源
        chainDefinition.addPathDefinition("favicon.ico", "anon");
        chainDefinition.addPathDefinition("/css/**", "anon");
        chainDefinition.addPathDefinition("/fonts/**", "anon");
        chainDefinition.addPathDefinition("/img/**", "anon");
        chainDefinition.addPathDefinition("/js/**", "anon");
        chainDefinition.addPathDefinition("/lib/**", "anon");
        // 设置登录功能可以访问
        chainDefinition.addPathDefinition("/sys/login", "anon");
        // 设置swagger可以访问
        chainDefinition.addPathDefinition("/swagger-ui.html", "anon");
        chainDefinition.addPathDefinition("/webjars/**", "anon");
        chainDefinition.addPathDefinition("/v2/**", "anon");
        chainDefinition.addPathDefinition("/swagger-resources/**", "anon");
        // 设置需要管理员才能访问
        chainDefinition.addPathDefinition("/sys/user/getUserByUsername.do", "authc");
        chainDefinition.addPathDefinition("/sys/user/**", "authc,roles[admin]");

        /* roles[python]中定义需要当前角色才能具有访问权限, 自定义Filter中的Object o就是roles["角色1","角色2"]中的数据
        chainDefinition.addPathDefinition("/my/python", "authc,roles[python]");*/

        // 需要登录才能访问
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }
}
