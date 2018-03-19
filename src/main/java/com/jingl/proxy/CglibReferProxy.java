package com.jingl.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Ben on 27/11/2017.
 */
public class CglibReferProxy implements Proxy{
    public <T> T getInstance(Class T) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(T);
        enhancer.setCallback(new RPCProxy());

        return (T) enhancer.create();
    }
}