package com.atguigu.springcloud.Util;

import com.atguigu.springcloud.controller.BaseController;

import java.io.*;


/**
 * @author hc
 * @version V1.0
 * @title FileUtil.java
 * @package com.xiye.common.util
 * @description 文件处理
 * @date 2019-05-11
 */
public class FileUtil extends BaseController {

    /**
     * @Author hc
     * @Date 2019-05-11 16:13:54
     * @Description 读取到字节数组2
     * @Param [filePath]
     * @Return byte[]
     */
    public static byte[] toByteArray2(String filePath) {
        // 构建文件对象
        File inputFile = new File(filePath);
        byte[] data = null;

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            data = baos.toByteArray();
            baos.close();
        } catch (Exception e) {
            com.xiye.common.util.LoggerUtil.error(e.toString(), e);
        }
        return data;
    }
}
