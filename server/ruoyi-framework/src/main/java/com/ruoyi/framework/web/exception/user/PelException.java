package com.ruoyi.framework.web.exception.user;

/**
 * 验证码错误异常类
 * 
 * @author ruoyi
 */
public class PelException extends UserException
{
    private static final long serialVersionUID = 1L;

    public PelException()
    {
        super("user.pel.error", null);
    }
}
