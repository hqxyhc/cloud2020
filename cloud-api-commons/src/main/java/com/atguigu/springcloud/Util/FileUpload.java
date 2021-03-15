package com.atguigu.springcloud.Util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author hc
 * @version V1.0
 * @title FileDownload.java
 * @package com.xiye.common.util
 * @description 上传文件
 * @date 2019-05-11
 */
public final class FileUpload {

    private FileUpload() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @Author hc
     * @Date 2019-05-11 16:34:50
     * @Description 上传文件
     * @Param [upload, filePath, fileName] upload 文件对象;filePath 上传路径;fileName 文件名
     * @Return java.lang.String
     */
    public static String fileUp(MultipartFile file, String filePath, String fileName) {
        try {
            String realName = copyFile(file.getInputStream(), filePath, fileName);
            realName = realName.replace("-", "");
            com.xiye.common.util.LoggerUtil.info("上传成功：" + realName);
        } catch (IOException e) {
            com.xiye.common.util.LoggerUtil.error(e.toString(), e);
        }
        return fileName;
    }

    /**
     * @Author hc
     * @Date 2019-05-11 16:35:34
     * @Description 写文件到当前目录的upload目录中
     * @Param [in, dir, realName]
     * @Return java.lang.String
     */
    public static String copyFile(InputStream in, String dir, String realName) throws IOException {
        File file = mkdirsmy(dir, realName);
        FileUtils.copyInputStreamToFile(in, file);
        in.close();
        return realName;
    }

    /**
     * @Author hc
     * @Date 2019-05-11 16:35:43
     * @Description 判断路径是否存在，否：创建此路径
     * @Param [dir, realName]
     * @Return java.io.File
     */
    public static File mkdirsmy(String dir, String realName) throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            boolean flag = file.createNewFile();
            if (!flag) {
                com.xiye.common.util.LoggerUtil.info("创建失败");
            }
        }
        return file;
    }
}
