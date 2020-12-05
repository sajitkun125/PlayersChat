package org.sajit.models;
/**
 * 
 * @author sajit
 * Player is both sender and receiver of messages
 */

public class Player {
	
    private String name;
    private String message;
    private TopicSubscriber topic;
    private int messageSentCounter=0;
    private int messageReveivedCounter =0 ;      
    private static final int MaxMessage = 10;
  

    public Player(String name) {
        this.name = name;
        this.message = "";
    }

    public void updatePlayerStat(boolean isInitiator) {
        String msg = (String) topic.getMessage(this);

        if (!isFinished()) {
            this.messageSentCounter++;  
            //Message received counter is not updated for player who starts communication
            if(!isInitiator) {
                this.messageReveivedCounter++;
            }
            this.message= ( messageSentCounter == 1 && isInitiator ) ? (this.message = msg + " " + messageSentCounter) : (this.message = msg + " , " + messageSentCounter);       
            this.topic.addMessage(this.message);
            System.out.println("Player " + name + ", Inputmessage: " + this.message);
        }
    }

    public boolean isFinished() {
    	boolean isfinished=messageSentCounter >= MaxMessage && messageReveivedCounter >=MaxMessage ;
        return isfinished;
    }
    
    public void setTopicSubscriber(TopicSubscriber topic) {
        this.topic = topic;
    }

}
