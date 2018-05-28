package cn.xiaomingx.springcloudmainservice;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@RestController
public class SpringcloudMainserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudMainserviceApplication.class, args);
	}
	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}
	@RequestMapping("/getsession")
	public  String getSession(HttpServletRequest req, HttpServletResponse rep){
        HttpSession sessoin=req.getSession();
        sessoin.setAttribute("username","TOM");
        sessoin.setAttribute("password","tommmm");
        sessoin.setMaxInactiveInterval(3000);
        Cookie cookie = new Cookie("springcloud",req.getSession().getId());
        cookie.setMaxAge(36000);
        cookie.setPath("/");
        rep.addCookie(cookie);
		return req.getSession().getId();
	}
	@RequestMapping("/getsession/{id}")
    public Object removeSession(@PathVariable("id")String id,HttpServletRequest req, HttpServletResponse rep){
	    Cookie[] cookies = req.getCookies();
        for (Cookie c:cookies) {
            if(c.getName().equals("springcloud")){
                return c.getValue();
            }

        }
        return req.getSession().getAttribute(id);
    }
}
