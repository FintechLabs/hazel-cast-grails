package com.hazelcast.messaging

import com.hazelcast.core.Message
import com.hazelcast.core.MessageListener
import com.hazelcast1.Person

class ListenerTwo implements MessageListener {

    @Override
    void onMessage(Message message) {
        Thread.sleep(5000)
        Person person = message.messageObject instanceof Person ? message.messageObject as Person : null
        println("**************             Person in Listener Two      ===>>>  ${person?.lastName}")
    }

}
