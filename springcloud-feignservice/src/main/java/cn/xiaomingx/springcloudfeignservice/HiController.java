package cn.xiaomingx.springcloudfeignservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Ming
 * @PROJECT: springcloud
 * @Package cn.xiaomingx.springcloudfeignservice
 * @date 2018/4/14 19:50
 * @Description: ${todo}
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return "feign:"+schedualServiceHi.sayHiFromClientOne(name);
    }
}