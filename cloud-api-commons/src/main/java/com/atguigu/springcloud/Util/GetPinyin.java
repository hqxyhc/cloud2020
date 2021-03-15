//package com.xiye.common.util;
//
//import net.sourceforge.pinyin4j.PinyinHelper;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//
///**
// * @author hc
// * @version V1.0
// * @title FileDownload.java
// * @package com.xiye.common.util
// * @description 汉字解析拼音处理
// * @date 2019-05-11
// */
//public final class GetPinyin {
//
//    private GetPinyin() {
//        throw new IllegalStateException("Utility class");
//    }
//    /**
//     * @Author hc
//     * @Date 2019-05-11 16:39:59
//     * @Description 得到 全拼
//     * @Param [src]
//     * @Return java.lang.String
//     */
//    public static String getPingYin(String src) {
//        char[] t1;
//        t1 = src.toCharArray();
//        String[] t2;
//        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
//        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
//        StringBuilder t4 = new StringBuilder();
//        try {
//            for (char aT1 : t1) {
//                /* 判断是否为汉字字符 */
//                if ("[\\u4E00-\\u9FA5]+".matches(Character.toString(aT1))) {
//                    t2 = PinyinHelper.toHanyuPinyinStringArray(aT1, t3);
//                    t4.append(t2[0]);
//                } else {
//                    t4.append(Character.toString(aT1));
//                }
//            }
//            return t4.toString();
//        } catch (BadHanyuPinyinOutputFormatCombination e1) {
//            com.xiye.common.util.LoggerUtil.error(e1.toString(),e1);
//        }
//        return t4.toString();
//    }
//
//    /**
//     * @Author hc
//     * @Date 2019-05-11 16:40:06
//     * @Description 得到中文首字母
//     * @Param [str]
//     * @Return java.lang.String
//     */
//    public static String getPinYinHeadChar(String str) {
//
//        StringBuilder convert = new StringBuilder();
//        for (int j = 0; j < str.length(); j++) {
//            char word = str.charAt(j);
//            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
//            if (pinyinArray != null) {
//                convert.append(pinyinArray[0].charAt(0));
//            } else {
//                convert.append(word);
//            }
//        }
//        return convert.toString();
//    }
//}
