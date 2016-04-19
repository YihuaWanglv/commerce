package com.iyihua.commerce.module.soa.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/***
 * 解析Channel注解，获取channel的key
 * @author Administrator
 *
 */
public class ChannelAnnotationParser {

	public static String[] getChannels(Object obj) {
		Class<?> bean = obj.getClass();
        String[] channel = null;
        //判断是否有Channel注解
        if (bean.isAnnotationPresent(Channel.class)) {
            //获取注解对象
            Annotation annotation = bean.getAnnotation(Channel.class);
            try {
                //获取注解@Channel所对应的channel
                Method method = Channel.class.getMethod("channel");
                channel = (String[]) method.invoke(annotation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return channel;
    }
}
