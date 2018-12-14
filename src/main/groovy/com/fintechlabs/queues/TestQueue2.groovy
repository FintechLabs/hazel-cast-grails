package com.fintechlabs.queues

import com.fintechlabs.Person
import com.hazelcast.core.Message
import com.hazelcast.core.MessageListener

class TestQueue2 implements MessageListener {

    @Override
    void onMessage(Message message) {
        Person person = message.messageObject as Person
        println("******************     Test Queue 2 Message Received   ====>>>>        ${person?.emailAddress}")
    }

}
