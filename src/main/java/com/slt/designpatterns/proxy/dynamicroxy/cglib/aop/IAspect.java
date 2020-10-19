package com.slt.designpatterns.proxy.dynamicroxy.cglib.aop;

/**
 * @Description： 定义切面接口，切面接口定义了两个切面方法，分别在切点接口方法执行前和执行后执行 <br/>
 */
public interface IAspect {
    /**
     * 在切点接口方法执行之前执行
     */
    void startTransaction();

    /**
     * 在切点接口方法执行之后执行
     */
    void endTrasaction();
}
