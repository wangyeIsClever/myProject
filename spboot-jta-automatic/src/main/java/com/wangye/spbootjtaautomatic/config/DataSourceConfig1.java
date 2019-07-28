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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.wangye.spbootjtaautomatic.mapper1",sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSourceConfig1 {

    @ConfigurationProperties(prefix = "spring.datasource.test1") //自定义配置数据源配置的前缀
    @Bean(name="test1DataSource")
    @Primary
    public DataSource testDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name="sqlSessionFactory1")
    @Autowired
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("test1DataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setTypeAliasesPackage("com.wangye.spbootjtaautomatic.model1");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper1/*.xml"));
        return factoryBean.getObject();
    }

    /**
     * 添加事务Bean
     * @param ds
     * @return
     */
    @Primary
    @Bean(name="transactionManager1")
    @Autowired
    public DataSourceTransactionManager transactionManager(@Qualifier("test1DataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Primary
    @Autowired
    @Bean(name="sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test1DataSource") DataSource ds) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory(ds));
        return template;
    }
}
