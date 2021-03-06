package com.jingl.rpc.common.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Ben on 26/11/2017.
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 520L;

    private long id;
    private String interfaceName;//服务对应接口名称
    private String methodName;//调用方法名称
    private Class[] types;  //返回值类型
    private Object[] params;//调用方法参数
    private Map values = new HashMap();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map getValues() {
        return values;
    }

    public void setValues(Map values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", interfaceName='" + interfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", types=" + Arrays.toString(types) +
                ", params=" + Arrays.toString(params) +
                ", values=" + values +
                '}';
    }
}
