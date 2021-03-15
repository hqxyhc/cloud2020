package com.atguigu.springcloud.Util;

import java.nio.file.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author hc
 * @version V1.0
 * @title FileZip.java
 * @package com.xiye.common.util
 * @description java压缩成zip
 * @date 2019-05-11
 */
public final class FileZip {

    private FileZip() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @Author hc
     * @Date 2019-05-11 13:39:29
     * @Description 方法描述
     * @Param [inputFileName, zipFileName]你要压缩的文件夹(整个完整路径),压缩后的文件(整个完整路径)
     * @Return java.lang.Boolean
     */
    public static Boolean zip(String inputFileName, String zipFileName) {
        zip(zipFileName, new File(inputFileName));
        return true;
    }

    private static void zip(String zipFileName, File inputFile) {

        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            zip(out, inputFile, "");
            out.flush();
        } catch (IOException e) {
            com.xiye.common.util.LoggerUtil.error(e.toString(), e);
        }
    }

    private static void zip(ZipOutputStream out, File f, String base) throws IOException {

        if (f.isDirectory()) {
            out.putNextEntry(new ZipEntry(base + "/"));
            File[] fl = f.listFiles();
            base = base.length() == 0 ? "" : (base + "/");
            assert fl != null;
            for (File aFl : fl) {
                zip(out, aFl, base + aFl.getName());
            }
        } else {
            try (FileInputStream in = new FileInputStream(f)) {
                out.putNextEntry(new ZipEntry(base));
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            } catch (IOException e) {
                com.xiye.common.util.LoggerUtil.error(e.toString(), e);
            }
        }

    }

    /**
     * @Author hc
     * @Date 2019-05-11 13:50:21
     * @Description 文件路径(只删除此路径的最末路径下所有文件和文件夹)
     * @Param [folderPath]
     * @Return void
     */
    public static Boolean delFolder(String folderPath) {
        /* 删除完里面所有内容 */
        try {
            delAllFile(folderPath);
            Path paths = Paths.get(folderPath);
            /* 删除空文件夹 */
            Files.delete(paths);
            return true;
        } catch (IOException e) {
            com.xiye.common.util.LoggerUtil.error(e.toString(), e);
            return false;
        }
    }

    /**
     * @Author hc
     * @Date 2019-05-11 13:50:13
     * @Description 删除指定文件夹下所有文件
     * @Param [path]
     * @Return boolean
     */
    public static Boolean delAllFile(String path) throws IOException {
        File file = new File(path);
        Boolean flag = false;
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp;
        assert tempList != null;
        for (String aTempList : tempList) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + aTempList);
            } else {
                temp = new File(path + File.separator + aTempList);
            }
            if (temp.isFile()) {
                Path paths = Paths.get(path + com.xiye.common.util.Const.FILEPATH_LEFT + aTempList);
                Files.delete(paths);
                flag = true;
            }
            if (temp.isDirectory()) {
                /* 先删除文件夹里面的文件 */
                delAllFile(path + "/" + aTempList);
                /* 再删除空文件夹 */
                flag = delFolder(path + "/" + aTempList);
            }
        }
        return flag;
    }

}

