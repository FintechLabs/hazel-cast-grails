package com.fintechlabs

import com.hazelcast.client.HazelcastClient
import com.hazelcast.client.config.ClientConfig
import com.hazelcast.config.GroupConfig
import com.hazelcast.core.HazelcastInstance

class HazelCastConfigBean {

    HazelcastInstance client = null

    HazelCastConfigBean() {
        ClientConfig clientConfig = new ClientConfig()
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:6876", "127.0.0.1:2356")
        clientConfig.setGroupConfig(new GroupConfig("dev", "dev-pass"))
        clientConfig.setProperty("hazelcast.client.statistics.enabled", "true")
        this.client = HazelcastClient.newHazelcastClient(clientConfig)
        println("Created HazelCast Client With Name   =>  ${this.client.name}")
        Enums.HazelCastQueue.values().each {
            createReliableTopicQueue("${it.name()}", Class.forName(it.className))
        }
    }

    def createReliableTopicQueue(String topicName, Class clazz) {
        println("***********************        Creating Reliable Topic named   ====>>>>>       ${topicName}")
        def iTopicQueue = client.getTopic(topicName)
        iTopicQueue.addMessageListener(clazz.newInstance())
        return iTopicQueue
    }

}
