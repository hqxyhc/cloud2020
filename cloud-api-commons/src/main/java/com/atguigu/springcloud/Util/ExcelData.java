package com.xiye.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelData
 * @Description: 描述
 * @Author hc
 * @Date 2020/5/14 9:42
 * @Version V1.0
 **/
public class ExcelData {

    public String[] getHead(){
        //表头数据
        String[] header = {"ID", "姓名", "性别", "年龄", "地址", "分数"};
        return header;
    }

    public String getFileName(){

        return "测试";
    }

    public List<String []> getData(){
        List<String[]> list=new ArrayList<String[]>(){
            {
                add(new String[]{"1", "小红", "女", "23", "成都青羊区", "96"});
                add(new String[]{"2", "小强", "男", "26", "成都金牛区", "91"});
                add(new String[]{"3", "小明", "男", "28", "成都武侯区", "90"});
            }
        };
        return list;
    }
}
