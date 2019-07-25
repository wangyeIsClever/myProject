package com.wangye.spbootmultidatasource.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.wangye.spbootmultidatasource.mapper2", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class Datasource2Configuration {


    private Datasource2Properties datasourceProperties;

    @Autowired
    public void setDatasourceProperties(Datasource2Properties datasourceProperties) {
        this.datasourceProperties = datasourceProperties;
    }

    @Bean(name = "test2DataSource")// 读取application.properties中的配置参数映射成为一个对象
    public DataSource getDateSource2() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(datasourceProperties.getUrl());
        hikariConfig.setUsername(datasourceProperties.getUsername());
        hikariConfig.setPassword(datasourceProperties.getPassword());
        hikariConfig.setDriverClassName(datasourceProperties.getDriverClassName());
        hikariConfig.setAutoCommit(datasourceProperties.getAutoCommit());
        hikariConfig.setConnectionTimeout(datasourceProperties.getConnectionTimeout());
        hikariConfig.setIdleTimeout(datasourceProperties.getIdleTimeout());
        hikariConfig.setMaxLifetime(datasourceProperties.getMaxLifetime());
        hikariConfig.setMinimumIdle(datasourceProperties.getMinimumIdle());
        hikariConfig.setMaximumPoolSize(datasourceProperties.getMaximumPoolSize());
        return new HikariDataSource(hikariConfig);
    }


    @Bean(name = "test2SqlSessionFactory")// @Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        // 设置mybatis的xml所在位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(datasourceProperties.getMapperLocations()));
        bean.setTypeAliasesPackage(datasourceProperties.getTypeAliasesPackage());
        return bean.getObject();
    }

    @Bean("test2SqlSessionTemplate")
    public SqlSessionTemplate test2sqlsessiontemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }


}
