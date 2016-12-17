package com.sonymm.manager.web.utils;

import com.sonymm.manager.web.entity.pojo.SystemInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 1:46
 */
public class SystemInfoUtil {

    public static SystemInfo getSystemInfo(){
        Runtime runtime = Runtime.getRuntime();
        Properties properties = System.getProperties();
        InetAddress addr = null;
        String ip = "";
        String hostName = "";
        try{
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e){
            ip = "无法获取主机IP";
            hostName = "无法获取主机名";
        }
        if(null != addr){
            try{
                ip = addr.getHostAddress();
            } catch (Exception e){
                ip = "无法获取主机IP";
            }
            try{
                hostName = addr.getHostName();
            }catch (Exception e){
                hostName = "无法获取主机名";
            }
        }
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setHostIp(ip);
        systemInfo.setArch(properties.getProperty("os.arch"));
        systemInfo.setHostName(hostName);
        systemInfo.setJavaHome(properties.getProperty("java.home"));
        systemInfo.setJavaUrl(properties.getProperty("java.vendor.url"));
        systemInfo.setJavaVersion(properties.getProperty("java.version"));
        systemInfo.setOsName(properties.getProperty("os.name"));
        systemInfo.setOsVersion(properties.getProperty("os.version"));
        systemInfo.setProcessors(String.valueOf(runtime.availableProcessors()));
        systemInfo.setVendor(properties.getProperty("java.vendor"));
        systemInfo.setTmpdir(properties.getProperty("java.io.tmpdir"));
        return systemInfo;
    }
}
