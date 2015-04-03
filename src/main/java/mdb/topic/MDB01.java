package mdb.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.Serializable;

/**
 * Created by root on 15-4-2.
 */
@MessageDriven(
        name = "MyMDB01",
        description = "this is my mdb01",
        mappedName = "jms/topic/testTopic",
        messageListenerInterface = MessageListener.class,
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination",propertyValue ="jms/topic/testTopic" ),
                @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Topic"),
                @ActivationConfigProperty(propertyName = "connectionParameters",propertyValue = "host=http-remoting://localhost;port=8080")
        }
)

public class MDB01 implements MessageListener {

    @Override
    public void onMessage(Message message) {

        TextMessage tmsg=(TextMessage)message;
        try {
            System.out.println("this is mdb01 "+tmsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
