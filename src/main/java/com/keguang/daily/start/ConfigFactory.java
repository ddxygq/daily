package com.keguang.daily.start;

import com.google.common.io.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigFactory {
    private final static Logger log = LogManager.getLogger("email");

    public static String kafkaipport = "hadoop01:9092,hadoop02:9092,hadoop03:9092";
    public static String kafkazookeeper;
    public static String kafkatopic = "topic";
    public static String kafkagroupid;
    public static String mysqlurl;
    public static String mysqlusername;
    public static String mysqlpassword;
    public static String redishost;
    public static int redisport;
    public static String redispassword;
    public static int redistimeout;
    public static int rediskeyexists;
    public static String sparkstreamname;
    public static int sparkstreamseconds;
    public static String sparkstreammaster = "spark://spark01:7077"; // 仅供本地测试使用
    public static String localpath = "src/file/flink-helper.txt";
    public static String checkpointdir;
    public static String keydeserilizer;
    public static String valuedeserilizer;

    /**
     * 初始化所有的通用信息
     */
    public static void initConfig(){readCommons();}

    /**
     * 读取commons.xml文件
     */
    private static void readCommons(){
        SAXReader reader = new SAXReader(); // 构建xml解析器
        Document document = null;
        try{
            document = reader.read(Resources.getResource("commons.xml"));
        }catch (DocumentException e){
            log.error("ConfigFactory.readCommons",e);
        }

        if(document != null){
            Element root = document.getRootElement();

            Element kafkaElement = root.element("kafka");
            kafkaipport = kafkaElement.element("ipport").getText();
            kafkazookeeper = kafkaElement.element("zookeeper").getText();
            kafkatopic = kafkaElement.element("topic").getText();
            kafkagroupid = kafkaElement.element("groupid").getText();
            keydeserilizer=kafkaElement.element("keySer").getText();
            valuedeserilizer=kafkaElement.element("valSer").getText();

            Element mysqlElement = root.element("mysql");
            mysqlurl = mysqlElement.element("url").getText();
            mysqlusername = mysqlElement.element("username").getText();
            mysqlpassword = mysqlElement.element("password").getText();

            Element redisElement = root.element("redis");
            redishost = redisElement.element("host").getText();
            redisport = Integer.valueOf(redisElement.element("port").getText());
            redispassword = redisElement.element("password").getText();
            redistimeout = Integer.valueOf(redisElement.element("timeout").getText());
            rediskeyexists = Integer.valueOf(redisElement.element("keyexists").getText());

            Element sparkElement = root.element("spark");
            // sparkstreammaster = sparkElement.element("streammaster").getText();
            sparkstreamname = sparkElement.element("streamname").getText();
            sparkstreamseconds = Integer.valueOf(sparkElement.element("seconds").getText());

            Element pathElement = root.element("path");
            localpath = pathElement.element("localpath").getText();
            checkpointdir = pathElement.element("checkpointdir").getText();
            // gracestopfile = pathElement.element("gracestopfile").getText();

        }else {
            log.warn("commons.xml配置文件读取错误...");
        }
    }
}
