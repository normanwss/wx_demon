package com.example.wc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
/**
 * 通过EnableWebSocketMessageBroker 开启使用STOMP协议来传输基于代理(message broker)的消息,
 * 此时浏览器支持使用@MessageMapping。
 */
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //配置消息代理(message broker)
        //广播式应配置一个/topic 消息代理
        config.enableSimpleBroker("/topic");
        //点对点式增加一个/queue 消息代理
        config.enableSimpleBroker("/queue", "/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //endPoint 注册协议节点,并映射指定的URl
        //注册一个Stomp 协议的endpoint,并指定 SockJS协议
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
        //注册一个名字为"endpointChat" 的endpoint,并指定 SockJS协议。   点对点-用
        registry.addEndpoint("/endpointChat").withSockJS();

    }
}
