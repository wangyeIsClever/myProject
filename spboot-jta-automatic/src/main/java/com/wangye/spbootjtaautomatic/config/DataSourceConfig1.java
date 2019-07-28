package com.wangye.spbootjtaautomatic.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
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
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.wangye.spbootjtaautomatic.mapper1",sqlSessionTemplateRef = "test1SqlSessionFactory")
public class DataSourceConfig1 {

    private DB1Properties db1Properties;

    @Autowired
    public void setDb1Properties(DB1Properties db1Properties) {
        this.db1Properties = db1Properties;
    }

    // 配置数据源
    @Primary
    @Bean(name = "test1DataSource")
    public DataSource test1DataSource() throws SQLException {
        // 首先要注意的是MySQL使用的DataSource 是MysqlXADataSource
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db1Properties.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(db1Properties.getPassword());
        mysqlXaDataSource.setUser(db1Properties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);


        //再者就是要把是MysqlXADataSource设置到AtomikosDataSourceBean中
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test1DataSource");
        xaDataSource.setMinPoolSize(db1Properties.getMinPoolSize());
        xaDataSource.setMaxPoolSize(db1Properties.getMaxPoolSize());
        xaDataSource.setMaxLifetime(db1Properties.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(db1Properties.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(db1Properties.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(db1Properties.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(db1Properties.getMaxIdleTime());
        xaDataSource.setTestQuery(db1Properties.getTestQuery());
        return xaDataSource;
    }

    @Primary
    @Bean(name = "test1SqlSessionFactory")
    @Autowired
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(db1Properties.getMapperLocations()));
        bean.setTypeAliasesPackage(db1Properties.getTypeAliasesPackage());
        return bean.getObject();
    }

    @Primary
    @Bean(name = "test1SqlSessionTemplate")
    @Autowired
    public SqlSessionTemplate test1SqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}
