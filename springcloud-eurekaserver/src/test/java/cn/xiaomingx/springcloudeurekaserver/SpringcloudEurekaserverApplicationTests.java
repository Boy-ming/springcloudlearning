package cn.xiaomingx.springcloudeurekaserver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudEurekaserverApplicationTests {
    @Test
    public void contextLoads() {
    }
/*
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("zzp","big z");
		Assert.assertEquals("big z",stringRedisTemplate.opsForValue().get("zzp"));
	}
	@Autowired
	private RedisTemplate<String,UserInfo> Template;

	@Test
	public void testobjSerializer() throws InterruptedException {
		UserInfo user = new UserInfo("111111","snow","112358");
		Template.opsForValue().set("User:snow",user);
		Assert.assertEquals(true,Template.hasKey("User:snow"));
	}
	@Test
	public void testobj() throws InterruptedException {
		UserInfo user = new UserInfo("15201803745","snow","112358");
		ValueOperations<String,UserInfo> operations = Template.opsForValue();
		operations.set("User:zzp",user);
		Thread.sleep(1000);
		operations.set("User:zzq",user);
		Thread.sleep(1000);
		Assert.assertEquals(true,Template.hasKey("User:zzp"));
		Assert.assertEquals(true,Template.hasKey("User:zzq"));
	}*/

}
