package com.kk.Server;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

/**
 * Created by hutwanghui on 2018/10/23.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class LeanCloudServer {
    public static void main(String[] args) throws AVException {

        AVOSCloud.useAVCloudCN();
        // 初始化参数依次为 AppId, AppKey, MasterKey
        AVOSCloud.initialize("DBWrnxNQ7wbV6LB1EtFg4X1o-gzGzoHsz"
                , "q351ri0F9mKbtjDOyx7E8AtR"
                , "qYIo8XSqpI8GiWQigKuivKJS");
        AVOSCloud.setDebugLogEnabled(true);
//        AVObject testObject = new AVObject("TestObject");
//        testObject.put("words", "Hello World!");
//        testObject.save();
    }
}
