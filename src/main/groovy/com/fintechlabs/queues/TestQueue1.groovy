package com.fintechlabs.queues

import com.hazelcast.core.Message
import com.hazelcast.core.MessageListener

class TestQueue1 implements MessageListener {

    @Override
    void onMessage(Message message) {
        println("******************     Test Queue 1 Message Received   ====>>>>        ${message.messageObject}")
    }

}
