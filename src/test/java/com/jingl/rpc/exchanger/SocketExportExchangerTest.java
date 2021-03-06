package com.jingl.rpc.exchanger;

import com.jingl.rpc.common.exceptions.ConnectionFailedException;
import com.jingl.rpc.common.exceptions.ServiceExportFailedException;
import com.jingl.rpc.common.exceptions.SocketCloseFailedException;
import com.jingl.rpc.handle.Handler;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Ben on 12/02/2018.
 */
public class SocketExportExchangerTest {

    /**
     * 暴露服务测试
     */
    @Test
    public void exportService() throws ServiceExportFailedException {

        Handler handler = new Handler() {
            @Override
            public byte[] invoke(Object val) {
                Socket socket = (Socket) val;
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    byte[] input = new byte[0];
                    int length = 0;

                    byte[] tmp = new byte[1024];
                    int data = inputStream.read(tmp);
                    if (data != -1) {
                        length += data;
                        input = ArrayUtils.addAll(input, tmp);
                    }
                    input = ArrayUtils.subarray(input, 0, length);
                    outputStream.write(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new byte[0];
            }
        };

//        Exchanger exchanger = new SocketExportTransfer(1234, handler);
//        exchanger.export();
        while (true) ;
    }


    /**
     * 关闭监听测试
     */
    @Test
    public void closeExport() throws ServiceExportFailedException, ConnectionFailedException, SocketCloseFailedException {


//        Exchanger exchanger = new SocketExportTransfer(1234, null);
//        exchanger.export();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//        }
//
//        exchanger.close();
    }
}
