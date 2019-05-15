package com.haohao.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author rienchou
 * @Description:
 * @date 2018/9/19 15:07
 */
/**
 * @author Administrator
 *
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    /** Redis数据库索引（默认为0） **/
    private String database;
    /** Redis服务器地址 **/
    private String host;
    /** Redis服务器连接端口 **/
    private int port;
    /** Redis服务器连接密码（默认为空） **/
    private String password;
    /** 连接池最大连接数（使用负值表示没有限制） **/
    private int poolMaxActive;
    /** 连接池最大阻塞等待时间（使用负值表示没有限制） **/
    private int poolMaxWait;
    /** 连接池中的最大空闲连接 **/
    private int poolMaxIdle;
    /** 连接池中的最小空闲连接 **/
    private int poolMinIdle;
    /** 连接最大等待时间（毫秒） **/
    private int poolMaxWaitMillis;

    @Bean
    public ShardedJedisPool shardedJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();//Jedis池配置
        config.setMaxTotal(poolMaxActive);
        config.setMaxWaitMillis(poolMaxWaitMillis);
        config.setMaxIdle(poolMaxIdle);
        List jdsInfoList = new ArrayList(1);
        JedisShardInfo infoA = new JedisShardInfo(host, port);
        infoA.setPassword(password);
        jdsInfoList.add(infoA);
        return new ShardedJedisPool(config, jdsInfoList);
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
   
    public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolMaxActive() {
        return poolMaxActive;
    }

    public void setPoolMaxActive(int poolMaxActive) {
        this.poolMaxActive = poolMaxActive;
    }

    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public int getPoolMinIdle() {
        return poolMinIdle;
    }

    public void setPoolMinIdle(int poolMinIdle) {
        this.poolMinIdle = poolMinIdle;
    }

    public int getPoolMaxWaitMillis() {
        return poolMaxWaitMillis;
    }

    public void setPoolMaxWaitMillis(int poolMaxWaitMillis) {
        this.poolMaxWaitMillis = poolMaxWaitMillis;
    }
}
