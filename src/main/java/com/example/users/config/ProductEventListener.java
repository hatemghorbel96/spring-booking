package com.example.users.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.users.entities.Notif;
import com.example.users.repository.NotifRepository;





@Component
public class ProductEventListener {

	@Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotifRepository notifRepository;
    
    @EventListener
    public void handleProductChangeEvent(Notif event) {
        
            messagingTemplate.convertAndSend("/topic/new",event);
        
    }
    
	/*
	 * @EventListener public void handleProductChangeEvent(Product event) {
	 * 
	 * messagingTemplate.convertAndSend("/topic/new", getAllProducts());
	 * 
	 * }
	 */
    
	/*
	 * @EventListener public void handleProductChangeEvent(Product event) {
	 * messagingTemplate.convertAndSend("/topic/new", getAllProducts()); }
	 */

   

}