package com.hazelcast

import com.hazelcast.client.HazelcastClient
import com.hazelcast.client.config.ClientConfig
import com.hazelcast.config.GroupConfig
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.ITopic
import com.hazelcast.messaging.ListenerOne
import com.hazelcast.messaging.ListenerTwo

class HazelCastConfigBean {

    HazelcastInstance client = null

    public HazelCastConfigBean() {
        ClientConfig clientConfig = new ClientConfig()
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:6876", "127.0.0.1:2356")
        clientConfig.setGroupConfig(new GroupConfig("dev", "dev-pass"))
        clientConfig.setProperty("hazelcast.client.statistics.enabled", "true")
        this.client = HazelcastClient.newHazelcastClient(clientConfig)
        println("Created HazelCast Client With Name   =>  ${this.client.name}")

        Enums.HazelCastMessagingQueueName.values().each {
            ITopic topic = client.getTopic(it.name())
            switch (it) {
                case Enums.HazelCastMessagingQueueName.QUEUE_ONE:
                    topic.addMessageListener(new ListenerOne())
                    break
                case Enums.HazelCastMessagingQueueName.QUEUE_TWO:
                    topic.addMessageListener(new ListenerTwo())
                    break
            }
        }
    }

}
