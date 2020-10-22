package com.slt.designpatterns.chainOfResponsibility;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1tK411W7xx?p=14
 * 场景：
 *    在论坛发表文章，文章会传到后台。需要审查过滤。才可以显示。
 *    处理msg
 *
 *    应该将 filter串在一起，这样对代码改动小
 */
public class Main {
    /**
     * 原始需求
     * 版本1
     * @param args
     */
    public static void main1(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好<script>,欢迎访问baidu.com,大家都是996");
        String str = msg.getMsg();
        //对msg 处理  < 可能攻击网站
        str = str.replace("<","[");
        str = str.replace(">","]");
        //对敏感词进行处理
        str = str.replaceAll("996","955");

        msg.setMsg(str);

        System.out.println(msg.getMsg());
    }

    /**
     * 版本2
     *
     * @param args
     */
    public static void main2(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好<script>,欢迎访问baidu.com,大家都是996");


        HtmlFilter htmlFilter = new HtmlFilter();
        htmlFilter.doFilter(msg);
        //对敏感词进行处理
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        sensitiveFilter.doFilter(msg);

        System.out.println(msg.getMsg());
    }

    /**
     * 版本3
     * 将 filter串在一起，这样对代码改动小
     * 责任链模式
     *  filter就像一个链条一样
     * @param args
     */
    public static void main3(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好<script>,欢迎访问baidu.com,大家都是996");
        List<Filter> filterList = new ArrayList<>();

        HtmlFilter htmlFilter = new HtmlFilter();
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        filterList.add(htmlFilter);
        filterList.add(sensitiveFilter);

        //处理消息
        for (Filter filter : filterList) {
            filter.doFilter(msg);
        }

        System.out.println(msg.getMsg());
    }

    /**
     * 版本4
     * 与版本3的区别：
     *  filterChain 可以和另一个 filterChain 连接在一起
     * @param args
     */
    public static void main4(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)<script>,欢迎访问baidu.com,大家都是996");

        FilterChain filterChain = new FilterChain();
        //链式调用
        filterChain.add(new HtmlFilter())
                .add(new SensitiveFilter());

        //第二个链条
        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new FaceFilter())
                .add(new UrlFilter());

        //将两个链条 连接在一起
        filterChain.add(filterChain2).doFilter(msg);
        System.out.println(msg.getMsg());
    }

    /**
     * 版本5
     * 由filterChain 中的某一个filter 决定链条是否继续
     * @param args
     */
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)<script>,欢迎访问baidu.com,大家都是996");

        FilterChain filterChain = new FilterChain();
        //链式调用
        filterChain.add(new HtmlFilter())
                .add(new SensitiveFilter());

        //第二个链条
        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new FaceFilter())
                .add(new UrlFilter());

        //将两个链条 连接在一起
        filterChain.add(filterChain2).doFilter(msg);
        System.out.println(msg.getMsg());
    }
}
@Data
@ToString
class Msg{
    String name;
    String msg;
}

/**
 * filter 版本1
 * 将变化部分 抽出来
 */
interface Filter2{
    void doFilter(Msg msg);
}

interface Filter{
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        //对msg 处理  < 可能攻击网站
        str = str.replace("<","[");
        str = str.replace(">","]");
        msg.setMsg(str);
        return true;
    }
}

/**
 * 敏感词的 filter
 */
class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        //对msg 处理  < 可能攻击网站
        str = str.replaceAll("996","955");
        msg.setMsg(str);
        return false;
    }
}

class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        //对msg 处理  < 可能攻击网站
        str = str.replace(":)","555");
        msg.setMsg(str);
        return true;
    }
}
class UrlFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        //对msg 处理  < 可能攻击网站
        str = str.replace("baidu.com","www.baidu.com");
        msg.setMsg(str);
        return true;
    }
}

/**
 * 链条
 */
class FilterChain implements Filter{
    List<Filter> filterList = new ArrayList<>();

    public FilterChain add(Filter filter){
        filterList.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Msg msg){
        for (Filter filter1 : filterList) {
            //链条中有一个返回来 false 就不循环了
            if(!filter1.doFilter(msg)){
                return false;
            }
        }
        return true;
    }
}
