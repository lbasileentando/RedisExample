package com.entando.demoredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName( "redis-12798.c100.us-east-1-4.ec2.cloud.redislabs.com");
        configuration.setPort(12798);
        configuration.setUsername("default");
        configuration.setPassword("OHSqL5fKj2UqThp17RLogs1SolaMcJgn");
        return new JedisConnectionFactory(configuration);
    }

     public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}
