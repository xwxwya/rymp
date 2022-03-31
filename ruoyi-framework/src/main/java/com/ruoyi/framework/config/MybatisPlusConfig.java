//package com.ruoyi.framework.config;
//
//
//import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
//import com.baomidou.mybatisplus.core.MybatisConfiguration;
//import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import com.ruoyi.framework.handler.MyMetaObjectHandler;
//import org.apache.ibatis.mapping.DatabaseIdProvider;
//import org.apache.ibatis.plugin.Interceptor;
//import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//
//import javax.sql.DataSource;
//
///**
// * @Description: MP配置
// * @Author: Steerforth
// * @Date: 2018/7/2
// */
//@Configuration
//public class MybatisPlusConfig {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private MybatisPlusProperties properties;
//
//    @Autowired
//    private ResourceLoader resourceLoader = new DefaultResourceLoader();
//
//
//    @Autowired(required = false)
//    private Interceptor[] interceptors;
//
//    @Autowired(required = false)
//    private DatabaseIdProvider databaseIdProvider;
//
//    /**
//     * @Description : mybatis-plus分页插件
//     * ---------------------------------
//     * @Author : Liang.Guangqing
//     * @Date : Create in 2017/9/19 13:59
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
//
//    @Bean
//    public GlobalConfig globalConfiguration(){
//        // MP 全局配置，更多内容进入类看注释
//        GlobalConfig globalConfig = new GlobalConfig();
//        //配置公共字段自动填写
//        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
////        globalConfig.setLogicDeleteValue("9");
////        globalConfig.setLogicNotDeleteValue("0");
//        return globalConfig;
//    }
//
//    @Bean
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
//        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//        mybatisPlus.setDataSource(dataSource);
//        mybatisPlus.setVfs(SpringBootVFS.class);
//        if (StringUtils.hasText(this.properties.getConfigLocation())) {
//            mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
//        }
//        mybatisPlus.setConfiguration(properties.getConfiguration());
//        if (!ObjectUtils.isEmpty(this.interceptors)) {
//            mybatisPlus.setPlugins(this.interceptors);
//        }
//        MybatisConfiguration mc = new MybatisConfiguration();
//        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        mybatisPlus.setConfiguration(mc);
//        if (this.databaseIdProvider != null) {
//            mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
//        }
//        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
//            mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//        }
//        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
//            mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//        }
//        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
//            mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
//        }
//        return mybatisPlus;
//    }
//
//}
