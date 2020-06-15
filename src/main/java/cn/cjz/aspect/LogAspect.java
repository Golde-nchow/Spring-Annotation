package cn.cjz.aspect;

import cn.cjz.annotation.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: Kam-Chou
 * @date: 2020/6/15 23:46
 * @description: 日志切面逻辑类
 * @version: 1.0
 */
@Aspect
public class LogAspect {

    /**
     * 使用切入点表达式声明切入点
     */
    @Pointcut("@annotation(cn.cjz.annotation.Log)")
    private void pointcut() {

    }

    /**
     * "@annotation(log)"
     * 当使用这个，那么就可以获取注解的信息，比如我们定义的value方法
     */
    @Before("pointcut() && @annotation(log)")
    public void adviceBefore(Log log) {
        System.out.println("当前方法：" + log.value());
    }

}
