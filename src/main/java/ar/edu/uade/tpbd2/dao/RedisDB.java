package ar.edu.uade.tpbd2.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import ar.edu.uade.tpbd2.persistence.model.redis.Usuario;

@Configuration
public class RedisDB {
    @Value("${spring.redis.host}")
    private String redisHostName;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory jedisConnectionFactory = new LettuceConnectionFactory();
        jedisConnectionFactory.setHostName(redisHostName);
        jedisConnectionFactory.setPort(redisPort);
        jedisConnectionFactory.setPassword(redisPassword);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Usuario> redisTemplate() {
        RedisTemplate<String, Usuario> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        //template.setKeySerializer(new StringRedisSerializer());
        //template.setValueSerializer(new GenericToStringSerializer<>(Usuario.class));
        return template;
    }
}
