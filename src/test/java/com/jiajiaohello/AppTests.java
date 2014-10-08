package com.jiajiaohello;

import com.jiajiaohello.support.core.CommonHelper;
import com.jiajiaohello.support.core.IpData;
import junit.framework.Assert;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRedis() {
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }

    @Test
    public void testHttp() {
        IpData ipData = CommonHelper.analyzeIP("119.80.62.130");
        System.out.println(ipData);
    }

    @Test
    public void testRedisTemplate() throws InterruptedException {
        String key = "test:testRedisTemplate";
        redisTemplate.opsForValue().set(key, 1, 2, TimeUnit.SECONDS);
        Assert.assertEquals(redisTemplate.opsForValue().get(key), 1);
        Thread.sleep(DateUtils.MILLIS_PER_SECOND * 2);
        Assert.assertNull(redisTemplate.opsForValue().get(key));
    }
}
