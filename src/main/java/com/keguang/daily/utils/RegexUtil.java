package com.keguang.daily.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具
 *
 * @author haisong
 * @create 2018/09/19 18:35
 */
public class RegexUtil {


    public String patternJsonStr(String orginStr){
        String result = patternStr(orginStr);
        result = result.replaceAll("\"\\{","{").replaceAll("\\}\"","}");
        result = filterGuid(result);
        return result;
    }


    public String patternStr(String orginStr){
        String regex = "\\\\*\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(orginStr);
        while (matcher.find()){
            String line = matcher.group();
            int num = appearNumber(line,"\\");
            String orginLine = line;
            String resultLine = line.replace("\\","");
            orginStr = orginStr.replace(orginLine,resultLine);
//            System.out.println("orginLine: "+orginLine+" line:"+line+" resultLine:"+resultLine);
        }
        return orginStr;
    }

    public String filterGuid(String orginStr){
        String regex = "(\"guid\":)(\\{)([0-9]|[a-z]|[A-Z]|\\-){36}(\\})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(orginStr);
        while (matcher.find()){
            String line = matcher.group();
            String resultLine = line.replace("{","\"{").replace("}","}\"");
            orginStr = orginStr.replace(line,resultLine);
//            System.out.println(" line:"+line+" resultLine:"+resultLine);
        }
        return orginStr;
    }
    private  int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

}
