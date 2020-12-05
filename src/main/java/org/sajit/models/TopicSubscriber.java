package org.sajit.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * @author sajit
 * Message class for recording message and starting conversation
 */
public class TopicSubscriber {
	private List<Player> players;
	    private String message;

	    public TopicSubscriber(String message) {
	        this.message = message;
	        this.players = new ArrayList<Player>();
	    }
	    
	    public void startCommunication() {
	        List<Player> players = getplayers();
            Iterator<Player> iterator = null; 
            boolean isfinish=false;
            boolean isInitiator =true ;
            
            while(true) {
            	iterator =  players.iterator();
        	    for (Player player : players) {       	    	
        	        player.updatePlayerStat(isInitiator);
        	        isInitiator=false ;
        	    }
	            while(iterator.hasNext()) {
	            	if(iterator.next().isFinished()) {
	            		isfinish=true ;
	            	} 
	            }
	            if(isfinish) {
	            	break;
	            }
           }
	    }

	    public void addToTopic(Player player) {
	        if (player == null) {
	            throw new NullPointerException("Player not defined");
	        }
		    if (!players.contains(player)) {
		         players.add(player);
		         player.setTopicSubscriber(this);
		    }
	    }
	  
	    public void removePlayer(Player player) {
	            players.remove(player);
	    }

	    public Object getMessage(Player player) {
	        final List<Player> players = getplayers();
            ListIterator<Player> iterator = players.listIterator(); 

            while (iterator.hasNext()){ 
            	if(iterator.next().isFinished()) {
            		return null ;
            	}
            }	
	        return this.message;
	    }

	    public void addMessage(String msg) {
	        this.message = msg;
	    }

	    private List<Player> getplayers() {
	        List<Player> playersLocal;
	        	playersLocal = new ArrayList<Player>(this.players);	 	    
	        return playersLocal;
	    }

}
