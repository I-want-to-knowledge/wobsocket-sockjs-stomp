package com.ws.ob.demo.websocket_sockjs_stomp2;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * 链接处理
 *
 * @author YanZhen
 * 2018-11-30 16:46:35
 * ClientConnectedHandler
 */
@Component
public class ClientConnectedHandler implements ApplicationListener<SessionConnectedEvent> {
	private Logger LOG = LoggerFactory.getLogger(ClientConnectedHandler.class);

	@Autowired
	private PushServer pushServer;
	
	@Override
	public void onApplicationEvent(SessionConnectedEvent event) {
		Principal user = event.getUser();
		if (user != null) {
			pushServer.afterClientConnected(user);
		} else {
			LOG.warn("没有收到用户的信息！");
		}
	}

}
