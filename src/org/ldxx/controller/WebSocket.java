package org.ldxx.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.ldxx.bean.User;
import org.ldxx.model.GetHttpSessionConfigurator;
 
 /**
  * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
  * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
  */
 @ServerEndpoint(value="/websocket",configurator=GetHttpSessionConfigurator.class)
 public class WebSocket{
     //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     private static int onlineCount = 0;

     //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     private static Map<String,WebSocket> webSocketSet = new HashMap<String,WebSocket>();
 
     //与某个客户端的连接会话，需要通过它来给客户端发送数据
     private Session session;
 
     private HttpSession httpSessionPage;
     /**
      * 连接建立成功调用的方法
      * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
      */
     @OnOpen
     public void onOpen(Session session,EndpointConfig config){
         this.session = session;
         HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
         User user = (User) httpSession.getAttribute("user");
         this.httpSessionPage = httpSession;
         webSocketSet.put(user.getUserId(),this);     //加入set中
         addOnlineCount();           //在线数加1
         System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
     }
 
     /**
      * 连接关闭调用的方法
      */
     @OnClose
     public void onClose(){
         webSocketSet.remove(this);  //从set中删除
         subOnlineCount();           //在线数减1
         System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
     }
 
     /**
      * 收到客户端消息后调用的方法
      * @param message 客户端发送过来的消息
      * @param session 可选的参数
      */
     @OnMessage
     public void onMessage(String message, Session session) {
         System.out.println("来自客户端的消息:" + message);
         
         //群发消息
         for(String key:webSocketSet.keySet()){
             try {
            	 webSocketSet.get(key).sendMessage(message);
             } catch (IOException e) {
                 e.printStackTrace();
                 continue;
             }
         }
     }
 
     /**
66      * 发生错误时调用
67      * @param session
68      * @param error
69      */
     @OnError
     public void onError(Session session, Throwable error){
         System.out.println("发生错误");
         error.printStackTrace();
     }
 
     /**
77      * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
78      * @param message
79      * @throws IOException
80      */
     public void sendMessage(String message) throws IOException{
         this.session.getBasicRemote().sendText(message);
         //this.session.getAsyncRemote().sendText(message);
     }
 
     public static synchronized int getOnlineCount() {
         return onlineCount;
     }
 
     public static synchronized void addOnlineCount() {
         WebSocket.onlineCount++;
     }
 
     public static synchronized void subOnlineCount() {
         WebSocket.onlineCount--;
     }
 }