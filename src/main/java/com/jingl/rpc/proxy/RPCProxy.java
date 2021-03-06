package com.jingl.rpc.proxy;

import com.jingl.rpc.common.entity.Invocation;
import com.jingl.rpc.common.entity.Request;
import com.jingl.rpc.common.exceptions.InvokerException;
import com.jingl.rpc.common.extension.ExtensionLoader;
import com.jingl.rpc.handle.Invoker;
import com.jingl.rpc.common.exceptions.FailToGenerateInvokerException;
import com.jingl.rpc.protocol.Protocol;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * Created by Ben on 27/11/2017.
 */
public class RPCProxy implements MethodInterceptor {
    private static final Logger logger = Logger.getLogger(RPCProxy.class);
    private static final Protocol protocol = (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class, "consumer").getActiveInstance();
    private final Invoker invoker = protocol.getInvoker();

    public RPCProxy() throws FailToGenerateInvokerException {
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Invocation invocation = new Invocation();

        invocation.setClazz(o.getClass().getInterfaces()[0]);
        Request request = invocation.getRequest();
        request.setInterfaceName(o.getClass().getInterfaces()[0].getName());
        request.setMethodName(method.getName());
        request.setParams(objects);
        request.setTypes(method.getParameterTypes());

        try {
            Object result = invoker.invoke(invocation);
            return result;
        } catch (InvokerException e) {
            throw e;
        }
    }
}
