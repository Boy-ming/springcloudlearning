package cn.xiaomingx.springcloudzuulservice;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;


/**
 * @author: Ming
 * @PROJECT: springcloud
 * @Package cn.xiaomingx.springcloudzuulservice
 * @date 2018/4/28 9:42
 * @Description: ${todo}
 */
@Component
public class RateLimitZullFilter extends ZuulFilter {
    private final RateLimiter rateLimiter = RateLimiter.create(100);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext currentContext = RequestContext.getCurrentContext();
            HttpServletResponse response = currentContext.getResponse();
            if (!rateLimiter.tryAcquire()) {
                HttpStatus httpStuats = HttpStatus.TOO_MANY_REQUESTS;
                response.setContentType(MediaType.TEXT_PLAIN_VALUE);
                response.setStatus(httpStuats.value());
                response.getWriter().append(httpStuats.getReasonPhrase());
                currentContext.setSendZuulResponse(false);
                throw new ZuulException(
                        httpStuats.getReasonPhrase(),
                        httpStuats.value(),
                        httpStuats.getReasonPhrase()
                );
            }
        }catch (Exception e){
            ReflectionUtils.rethrowRuntimeException(e);
        }
        return null;
    }
}
