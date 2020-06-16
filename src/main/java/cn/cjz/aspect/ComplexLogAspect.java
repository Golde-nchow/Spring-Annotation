package cn.cjz.aspect;

import cn.cjz.annotation.ComplexLog;
import cn.cjz.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: Kam-Chou
 * @date: 2020/6/16 9:30
 * @description: 复杂注解的切面逻辑
 * @version: 1.0
 */
@Aspect
@Component
public class ComplexLogAspect {

    @Pointcut("@annotation(cn.cjz.annotation.ComplexLog)")
    public void pointcut() {

    }

    /**
     * 使用 @Around 建议使用ProceedingJoinPoint，并且返回一个值
     * getSignature：获取方法的签名
     *
     */
    @Around("pointcut() && @annotation(log)")
    public Object advice(ProceedingJoinPoint joinPoint, ComplexLog log) {
        System.out.println("正在调用：["
                + joinPoint.getSignature().getDeclaringType().getSimpleName() + "]["
                + joinPoint.getSignature().getName() + "]");

        Object result = null;

        // 获取方法的参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("获取参数：" + arg);
        }

        try {
            // 调用切入点的逻辑
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        if (result instanceof User) {
            User user = (User) result;

            if ("findUserById2".equals(joinPoint.getSignature().getName())) {
                user.setUsername("处理后的用户名");
            } else {
                user.setPassword("处理后的密码");
            }

            return user;
        }

        return result;
    }

}
