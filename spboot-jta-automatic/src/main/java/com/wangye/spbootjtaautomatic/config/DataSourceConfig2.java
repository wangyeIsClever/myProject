package com.wangye.spbootjtaautomatic.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages="com.wangye.spbootjtaautomatic.mapper2",sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSourceConfig2 {

    private DB2Properties db2Properties;

    @Autowired
    public void setdb2Properties(DB2Properties db2Properties) {
        this.db2Properties = db2Properties;
    }

    // 配置数据源2
    @Bean(name = "test2DataSource")
    public DataSource test2DataSource() throws SQLException {
        // 首先要注意的是MySQL使用的DataSource 是MysqlXADataSource
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db2Properties.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(db2Properties.getPassword());
        mysqlXaDataSource.setUser(db2Properties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);


        //再者就是要把是MysqlXADataSource设置到AtomikosDataSourceBean中
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test2DataSource");
        xaDataSource.setMinPoolSize(db2Properties.getMinPoolSize());
        xaDataSource.setMaxPoolSize(db2Properties.getMaxPoolSize());
        xaDataSource.setMaxLifetime(db2Properties.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(db2Properties.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(db2Properties.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(db2Properties.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(db2Properties.getMaxIdleTime());
        xaDataSource.setTestQuery(db2Properties.getTestQuery());

        return xaDataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(db2Properties.getMapperLocations()));
        bean.setTypeAliasesPackage(db2Properties.getTypeAliasesPackage());
        SqlSessionFactory sqlSessionFactory = bean.getObject();
        return sqlSessionFactory;
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate test2SqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
