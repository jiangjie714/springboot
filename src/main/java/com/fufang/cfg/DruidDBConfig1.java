package com.fufang.cfg;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import ch.qos.logback.classic.Logger;

/**
 * 每多一个数据源就要多加一个配置文件
 * 貌似很呆的样子。。。后续看能不能做到比较方便的。
 * 该 多数据源配置 方式参考来源与阿里云社区的代码
 * @author jie
 *
 */

@Configuration  															
@MapperScan(basePackages = DruidDBConfig1.PACKAGE, sqlSessionFactoryRef = "acSessionFactory1")
public class DruidDBConfig1 {  
	static final String PACKAGE = "com.fufang.bi.mapper";

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	          
	@Value("${spring.datasource.ffds1.url}")  
    private String dbUrl;  
      
    @Value("${spring.datasource.ffds1.username}")  
    private String username;  
      
    @Value("${spring.datasource.ffds1.password}")  
    private String password;  
      
    @Value("${spring.datasource.ffds1.driverClassName}")  
    private String driverClassName;  
    
    
    @Value("${spring.datasource.initialSize}")  
    private int initialSize;  
      
    @Value("${spring.datasource.minIdle}")  
    private int minIdle;  
      
    @Value("${spring.datasource.maxActive}")  
    private int maxActive;  
      
    @Value("${spring.datasource.maxWait}")  
    private int maxWait;  
      
    @Value("${spring.datasource.maxWait}")  
    private int timeBetweenEvictionRunsMillis;  
      
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
    private int minEvictableIdleTimeMillis;  
      
    @Value("${spring.datasource.validationQuery}")  
    private String validationQuery;  
      
    @Value("${spring.datasource.testWhileIdle}")  
    private boolean testWhileIdle;  
      
    @Value("${spring.datasource.testOnBorrow}")  
    private boolean testOnBorrow;  
      
    @Value("${spring.datasource.testOnReturn}")  
    private boolean testOnReturn;  
      
    @Value("${spring.datasource.poolPreparedStatements}")  
    private boolean poolPreparedStatements;  
      
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;  
    
    @Value("${spring.datasource.ffds1.filters}")  
    private String filters;  
    
    @Value("{spring.datasource.ffds1.connectionProperties}")  
    private String connectionProperties;  
      
    @Bean(name = "ffds1")     //声明其为Bean实例   rdsdatasource1
    public DataSource dataSource(){  
        DruidDataSource datasource = new DruidDataSource();  
          
        datasource.setUrl(this.dbUrl);  
        datasource.setUsername(username);  
        datasource.setPassword(password);  
        datasource.setDriverClassName(driverClassName);  
          
        //configuration  
      //configuration  
        datasource.setInitialSize(initialSize);  
        datasource.setMinIdle(minIdle);  
        datasource.setMaxActive(maxActive);  
        datasource.setMaxWait(maxWait);  
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
        datasource.setValidationQuery(validationQuery);  
        datasource.setTestWhileIdle(testWhileIdle);  
        datasource.setTestOnBorrow(testOnBorrow);  
        datasource.setTestOnReturn(testOnReturn);  
        datasource.setPoolPreparedStatements(poolPreparedStatements);  
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
        try {  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
            logger.error("druid configuration initialization filter", e);  
        }  
        datasource.setConnectionProperties(connectionProperties);  
          //logger.info(maxPoolPreparedStatementPerConnectionSize+"");
        return datasource;  
    }  
    
    @Bean(name = "acTransactionManager1")
    public DataSourceTransactionManager rdsTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    @Bean(name = "acSessionFactory1")
    public SqlSessionFactory rdsSqlSessionFactory(@Qualifier("ffds1") DataSource rdsDataSource1) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rdsDataSource1);
        return sessionFactory.getObject();
    }
} 