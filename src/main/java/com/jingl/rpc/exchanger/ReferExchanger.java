package com.jingl.rpc.exchanger;

import com.jingl.rpc.common.Constants;
import com.jingl.rpc.common.annotation.Impl;
import com.jingl.rpc.common.entity.URL;
import com.jingl.rpc.common.exceptions.ConnectionFailedException;
import com.jingl.rpc.handle.Invoker;

/**
 * Created by Ben on 25/03/2018.
 */
@Impl(value = "netty",property = Constants.PROPERTY_EXPORT_EXCHANGER)
public interface ReferExchanger extends Exchanger {

    int refer() throws ConnectionFailedException;

    boolean isDead();

    void setParams(URL url, Invoker invoker);
}
