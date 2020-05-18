package com.chensee.Exception;

import com.chensee.Exception.entity.CustomExceptionEntity;
import com.chensee.Exception.entity.SysExceptionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Map;

/**
 * 全局Controller层异常处理类 ExceptionHandler拦截异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionResolver {

    @Autowired
    private SysExceptionEntity sysExceptionEntity;

    @Autowired
    private CustomExceptionEntity customExceptionEntity;

    /**
     * 处理所有系统不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult handleException(Exception e) {
        // 打印异常堆栈信息
        Map<String, String> sysExceptionMap = sysExceptionEntity.getCustomException();
        String sysExceptionMsg = null;
        for (Map.Entry<String, String> entry : sysExceptionMap.entrySet()) {
            String sysExceptionName = entry.getKey();
            try {
                Class<?> aClass = Class.forName(sysExceptionName);
                if (e.getClass().isAssignableFrom(aClass)) {
                    sysExceptionMsg = entry.getValue();
                    break;
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        String msg = sysExceptionMsg != null ? sysExceptionMsg : sysExceptionEntity.getOtherException();
        return ApiResult.fail2(msg);
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(BusinessRuntimeException.class)
    @ResponseBody
    public ApiResult handleOpdRuntimeException(BusinessRuntimeException e) {
        // 不打印异常堆栈信息
        log.error(e.getMsg());
        return ApiResult.of(e.getResultCode());
    }

    /**
     * 处理所有自定义异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(BusinessException1.class)
    @ResponseBody
    public ApiResult handleOpdRuntimeException(BusinessException1 e) {
        Map<String, String> exception = customExceptionEntity.getException();
        String code = e.getCode();
        String param = e.getParam();
        String msg = exception.get(code);
        if (param != null) {
            msg = ParamConvertUtil.parseParams1(msg, param);
        }
        return ApiResult.fail(code,msg);
    }

    /**
     * get请求参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ApiResult handleBingException(MissingServletRequestParameterException e) {
        String parameterName = e.getParameterName();
        Map<String, String> sysExceptionMap = sysExceptionEntity.getCustomException();
        String sysExceptionMsg = null;
        for (Map.Entry<String, String> entry : sysExceptionMap.entrySet()) {
            String sysExceptionName = entry.getKey();
            try {
                Class<?> aClass = Class.forName(sysExceptionName);
                if (e.getClass().isAssignableFrom(aClass)) {
                    sysExceptionMsg = entry.getValue();
                    break;
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        String msg = sysExceptionMsg != null ? sysExceptionMsg : sysExceptionEntity.getOtherException();
        msg = ParamConvertUtil.parseParams1(msg,parameterName);
        return ApiResult.fail2(msg);
    }

    /**
     * post请求参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ApiResult.fail2(defaultMessage);
    }

    /**
     * 请求方法中校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResult constraintViolationExceptionHandler(ConstraintViolationException e){
        //获取异常中第一个错误信息
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return ApiResult.fail2(message);
    }
}
