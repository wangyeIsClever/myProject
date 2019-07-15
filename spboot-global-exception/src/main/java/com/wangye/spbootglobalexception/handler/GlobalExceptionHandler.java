package com.wangye.spbootglobalexception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // 定义一个通知，在异常发生之后执行
public class GlobalExceptionHandler {

    /**
     * @param e 业务接口锁抛出的异常
     * @param request 请求接口时的请求封装对象
     * @return 异常信息 json格式
     */
    @ExceptionHandler(RuntimeException.class) // 这里表示拦截所有运行时的异常
    @ResponseBody
    public Map<String,Object> handler(Exception e, HttpServletRequest request){
        // 定义发生异常时要返回的参数
        Map<String,Object> data = new HashMap<>();
        data.put("msg","请求错误");
        data.put("code","500");
        // 下面是模拟 异常 e.printStackTrace(); 在整合日志框架之后，就要把错误输出到日志里
        System.err.println(getMessage(e));
        return data;
    }

    /**
     * @param e 抛出的异常
     * @return 异常的堆栈信息
     */
    public static String getMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }


}
