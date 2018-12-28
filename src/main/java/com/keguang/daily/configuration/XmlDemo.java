package com.keguang.daily.configuration;

import com.google.common.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读写xml文件
 */
public class XmlDemo {
    /**
     * 读取xml文件
     * @param args
     */
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();

        // Document document = reader.read(new File("src/main/resources/sys-config.xml"));

        // Resources.getResource 方法只识别resources目录下的相对路径文件，不识别绝对路径
        Document document = reader.read(Resources.getResource("sys-config.xml"));
        Element config = document.getRootElement(); // 获得根节点
        Element dbinfo = config.element("db-info"); // 获得元素子节点
        String drivername = dbinfo.element("driver-name").getText();
        String url = dbinfo.element("url").getText();
        String username = dbinfo.element("user-name").getText();
        String password = dbinfo.element("password").getText();

        System.out.println(drivername);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);

    }
}
