package com.example;

import com.example.miraijava.handler.MyEventHandlers;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.ListenerHost;
import net.mamoe.mirai.event.events.BotEvent;
import net.mamoe.mirai.utils.BotConfiguration;


import java.io.File;


public class MiraiJavaApplication {
    public static void main(String[] args) {
        String qq = "3152364256";
        final String filePath = "src/work_dir";
        final String password = "";
        Bot bot = BotFactory.INSTANCE.newBot(Long.parseLong(qq),password , new BotConfiguration() {{
            //设置登录协议
            setProtocol(MiraiProtocol.ANDROID_PAD);
            //设置工具目录
            setWorkingDir(new File(filePath));
            //设置cache目录
            setCacheDir(new File("cache"));
            //Bot 默认使用全随机的设备信息。
            fileBasedDeviceInfo("device.json");
        }}).getBot();
        bot.login();
        /**
         * 添加事件注册
         */
        EventChannel channel = GlobalEventChannel.INSTANCE.filter(ev -> ev instanceof BotEvent && ((BotEvent) ev).getBot().getId() == Long.parseLong(qq));
        channel.registerListenerHost((ListenerHost) new MyEventHandlers());
    }
}
