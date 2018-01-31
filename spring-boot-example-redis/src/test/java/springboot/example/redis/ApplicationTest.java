package springboot.example.redis;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTempate;
	
	@Test
	public void test() {
		stringRedisTempate.opsForValue().set("test", "xxxxxxxxxxxxxxx");
		
		for(int i=100; i<=200; i++) {
			redisTemplate.opsForValue().set("ID" + i, new User((long)i, "User"+i, i));
		}
		
		Serializable user = redisTemplate.opsForValue().get("ID110");
		System.out.println(user);
	}
}
