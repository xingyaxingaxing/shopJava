package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    private final static  Logger log = LoggerFactory.getLogger(WebSocket.class);

    private static CopyOnWriteArraySet<WebSocket>webSockets=new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSockets.add(this);
        log.info("【websocket消息】有新的连接，总数:{}",webSockets.size());
    }
    @OnClose
    public void onClose(){
        webSockets.remove(this);
        log.info("【websocket消息】连接断开，总数:{}",webSockets.size());
    }
    @OnMessage
    public void onMessage(String message){
        log.info("【websocket消息】收到客户端发来信息:{}",message);
    }
    public void sendMessage(String message){
        for(WebSocket webSocket:webSockets){
            log.info("【websocket消息】广播消息，message={}",message);
            try{
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
