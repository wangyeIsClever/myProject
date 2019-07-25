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
@MapperScan(basePackages = "com.wangye.spbootmultidatasource.mapper1", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class Datasource1Configuration {


    private Datasource1Properties datasourceProperties;

    @Autowired
    public void setDatasourceProperties(Datasource1Properties datasourceProperties) {
        this.datasourceProperties = datasourceProperties;
    }

    @Bean(name = "test1DataSource")
    @Primary// 表示这个数据源是默认数据源 // 读取application.properties中的配置参数映射成为一个对象
    public DataSource getDateSource1() {
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


    @Bean(name = "test1SqlSessionFactory")
    @Primary // 表示这个数据源是默认数据源 // @Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        // 设置mybatis的xml所在位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(datasourceProperties.getMapperLocations()));
        bean.setTypeAliasesPackage(datasourceProperties.getTypeAliasesPackage());
        return bean.getObject();
    }

    @Bean("test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate test1sqlsessiontemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }


}
