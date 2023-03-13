package com.kk.aop;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.kk.service.util.ThreadLocalDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Aspect
@Service
@Order(-5)
public class RequestLogAspect {

    private static Logger logger = LoggerFactory.getLogger("request");

    @Around("execution(public * com.kk.api.impl.*.*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        MDC.put("traceId", UUID.randomUUID().toString());
        long start = System.currentTimeMillis();
        String requestReceivedTime = ThreadLocalDateFormat.current().format(new Date());
        String paramString = getParamsString(joinPoint.getArgs());
        String resultString = "";
        String consumer = getClientName();
        String clientIp = getClientIp();
        String localIp = getLocalIp();
        try {
            Object ret = joinPoint.proceed();
            if (ret instanceof Object) {
              //  if (ret instanceof PlainResult) {
//                //只记录code和message
//                PlainResult rawResult = (PlainResult) ret;
//                PlainResult<?> result = new PlainResult<>();
//                if (rawResult.isOk()) {
//                    result.success(null);
//                } else {
//                    result = rawResult;
//                }
//                resultString = JSON.toJSONString(result);
//            } else {
//                resultString = JSON.toJSONString(ret);
            }
            return ret;
        } finally {
            long cost = System.currentTimeMillis() - start;

            String SEPARATOR = " | ";
            String sb = requestReceivedTime +
                SEPARATOR + getMethodString(joinPoint) +
                SEPARATOR + paramString +
                SEPARATOR + consumer +
                SEPARATOR + clientIp +
                SEPARATOR + localIp +
                SEPARATOR + resultString +
                SEPARATOR + cost +
                "ms";
            logger.info(sb);
            MDC.clear();
        }
    }

    private String getClientName() {
        try {
            return RpcContext.getContext().getAttachment("consumer_application");
        } catch (Exception e) {
            //log.error("获取调用方远程ip发生异常，"+ e.getMessage());
            return "unknown";
        }
    }

    private String getClientIp() {
        try {
            return RpcContext.getContext().getRemoteHost();
        } catch (Exception e) {
            //log.error("获取调用方远程ip发生异常，"+ e.getMessage());
            return "unknown";
        }
    }

    private String getLocalIp() {
        try {
            return RpcContext.getContext().getLocalHost();
        } catch (Exception e) {
            //log.error("获取调用方远程ip发生异常，"+ e.getMessage());
            return "unknown";
        }
    }

    private String getParamsString(Object[] args) {
        if (args.length == 0) {
            return "";
        } else {
            List<String> params = Arrays.stream(args).map(JSON::toJSONString).collect(Collectors.toList());
            return StringUtils.join(params, ",");
        }
    }

    private String getMethodString(ProceedingJoinPoint joinPoint) {
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        Method method = joinPointObject.getMethod();

        return method.getDeclaringClass().getSimpleName() + " " + method.getName();
    }
}
