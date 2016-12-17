package com.sonymm.manager.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 16:50
 */
public class IOResourceUtil {
    private static final Logger logger = LoggerFactory.getLogger( IOResourceUtil.class );

    public static void closeResource( Closeable stream ) {
        if ( stream == null ) {
            return;
        }
        try {
            stream.close( );
        } catch ( Exception e ) {
            if ( logger.isErrorEnabled( ) ) {
                logger.error( "close stream error!" , e );
            }
        }
    }

    /**
     * 获取Classpath路径
     *
     * @return
     */
    public static String getClasspath( ) {
        String classPath = Thread.currentThread( ).getContextClassLoader( ).getResource( "" ).getPath( );
        String rootPath = "";
        // windows
        if ( "\\".equals( File.separator ) ) {
            rootPath = classPath.substring( 1 );
            rootPath = rootPath.replace( "/", "\\" );
        }
        // linux
        if ( "/".equals( File.separator ) ) {
            rootPath = classPath.substring( 1 );
            rootPath = rootPath.replace( "\\", "/" );
        }
        return rootPath;
    }
}
