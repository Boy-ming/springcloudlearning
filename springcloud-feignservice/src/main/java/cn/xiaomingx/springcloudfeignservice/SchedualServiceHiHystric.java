package cn.xiaomingx.springcloudfeignservice;

import org.springframework.stereotype.Component;

/**
 * @author: Ming
 * @PROJECT: springcloud
 * @Package cn.xiaomingx.springcloudfeignservice
 * @date 2018/4/14 20:00
 * @Description: ${todo}
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}