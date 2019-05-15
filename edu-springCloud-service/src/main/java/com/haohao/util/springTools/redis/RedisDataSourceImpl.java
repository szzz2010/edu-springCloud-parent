package com.haohao.util.springTools.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
 * redis连接管理类
 *
 * @author rienniu
 * @version 201609
 * @date 2016年9月27日下午4:48:16
 */
@Component
public class RedisDataSourceImpl implements RedisDataSource {

    private static Log log = LogFactory.getLog(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getRedisClient error", e);
        }
        return null;
    }

    public void close(ShardedJedis shardedJedis) {
        shardedJedis.close();
    }
}
