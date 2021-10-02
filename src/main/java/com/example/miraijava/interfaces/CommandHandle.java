package com.example.miraijava.interfaces;

import net.mamoe.mirai.event.events.MessageEvent;

/**
 * @Author dailinfeng
 * @Description TODO
 * @Date 2021/9/18 1:35 下午
 * @Version 1.0
 */
public interface CommandHandle {
    /**
     * 处理命令的抽象类
     *
     * @param event 事件
     */
    void handleCommand(MessageEvent event);
}
