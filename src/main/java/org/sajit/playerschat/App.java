package org.sajit.playerschat;
import org.sajit.models.TopicSubscriber;
import org.sajit.models.Player;

public class App 
{
    public static void main( String[] args )
    {
    	  if (args.length != 1) {
              throw new RuntimeException("Input message required");
          }

    	  TopicSubscriber topic = new TopicSubscriber(args[0]);

    	  Player initiator = new Player("initiator");
    	  Player second = new Player("Second Player");

    	  topic.addToTopic(initiator);
    	  topic.addToTopic(second);

    	  /*
    	   * Starting communication between players
    	   */
    	  topic.startCommunication();
          System.out.println("Communication completed");
    }
}
