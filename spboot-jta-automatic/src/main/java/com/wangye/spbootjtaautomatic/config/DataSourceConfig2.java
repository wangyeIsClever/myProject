package com.wangye.spbootjtaautomatic.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.wangye.spbootjtaautomatic.mapper2",sqlSessionFactoryRef = "sqlSessionTemplate2")
public class DataSourceConfig2 {

    @ConfigurationProperties(prefix = "spring.datasource.test2") //自定义配置数据源配置的前缀
    @Bean(name="test2DataSource")
    public DataSource testDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name="sqlSessionFactory2")
    @Autowired
    public SqlSessionFactory sqlSessionFactory(@Qualifier("test2DataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setTypeAliasesPackage("com.wangye.spbootjtaautomatic.model2");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper2/*.xml"));
        return factoryBean.getObject();
    }

    /**
     * 添加事务Bean
     * @param ds
     * @return
     */
    @Bean(name="transactionManager2")
    @Autowired
    public DataSourceTransactionManager transactionManager(@Qualifier("test2DataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Autowired
    @Bean(name="sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test2DataSource") DataSource ds) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory(ds));
        return template;
    }
}
