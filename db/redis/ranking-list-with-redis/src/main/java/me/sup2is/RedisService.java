package me.sup2is;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RedisService {

    private final String KEY = "player";

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String,String,String> hashOperations;

    public void add() {
        try (Jedis jedis = new Jedis(redisHost, redisPort)) {
            Pipeline pipeline = jedis.pipelined();
            for (int i = 0; i < 10_000_000; i++) {
                pipeline.zadd(KEY,  i * (int)(Math.random() * 10_000_000) + 1, String.valueOf(i * (int)(Math.random() * 10_000_000) + 1));
            }
            pipeline.sync();
        }
    }

    public List<String> getPlayers() {
        Set<String> range = zSetOperations.reverseRange(KEY, 0, 49_999);
        return new ArrayList<>(range);
    }

}
