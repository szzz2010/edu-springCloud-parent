package com.haohao.util.paramAndDto;
//package com.haohao.util.paramAndDto;
//
//import java.util.List;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.logging.log4j.util.Strings;
//
//import com.google.common.base.Joiner;
//import com.google.common.collect.Lists;
//
//import net.sourceforge.pinyin4j.PinyinHelper;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//
///**
// * @Desc 拼音工具
// * @Author xiekunliang
// * @Date 2018/5/16 21:45
// */
//public class PinyinUtil {
//
//    private static Log log = LogFactory.getLog(PinyinUtil.class);
//
//    private PinyinUtil() {
//    }
//
//    /**
//     * 获取汉字串拼音首字母，英文字符不变
//     *
//     * @param chinese 汉字串
//     * @return 汉语拼音首字母
//     */
//    public static String getFirstSpell(String chinese) {
//        StringBuffer pybf = new StringBuffer();
//        try {
//            char[] arr = chinese.toCharArray();
//            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//            defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] > 128) {
//                    try {
//                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
//                        if (temp != null) {
//                            pybf.append(temp[0].charAt(0));
//                        }
//                    } catch (BadHanyuPinyinOutputFormatCombination e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    pybf.append(arr[i]);
//                }
//            }
//        } catch (Exception e) {
//            log.error("汉字获取首字母拼音异常：", e);
//        }
//        return pybf.toString().replaceAll("\\W", "").trim();
//    }
//
//    /**
//     * 获取汉字串拼音，英文字符不变
//     *
//     * @param chinese 汉字串
//     * @return 汉语拼音
//     */
//    public static String getFullSpell(String chinese) {
//        StringBuffer pybf = new StringBuffer();
//        try {
//            char[] arr = chinese.toCharArray();
//            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//            defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] > 128) {
//                    try {
//                        pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
//                    } catch (BadHanyuPinyinOutputFormatCombination e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    pybf.append(arr[i]);
//                }
//            }
//        } catch (Exception e) {
//            log.error("汉字获取全拼异常：", e);
//        }
//        return pybf.toString();
//    }
//
//
//    public static String createPinyinKey(String... chinese) {
//        if (chinese != null) {
//            try {
//                List<String> sb = Lists.newLinkedList();
//                for (String value : chinese) {
//                    value = Strings.nullToEmpty(value).trim();
//                    if (Strings.isNullOrEmpty(value)) {
//                        continue;
//                    }
//                    String f = getFirstSpell(value);
//                    String a = getFullSpell(value);
//                    sb.add(f);
//                    sb.add(a);
//                }
//                String key = Joiner.on("|").join(sb);
//                sb.clear();
//                return key;
//            } catch (Exception e) {
//                log.error("获取【" + chinese + "】拼音出错", e);
//            }
//        }
//        return "";
//    }
//}
