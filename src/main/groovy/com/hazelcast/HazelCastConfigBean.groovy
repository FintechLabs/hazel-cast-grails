package com.hazelcast

import com.hazelcast.client.HazelcastClient
import com.hazelcast.client.config.ClientConfig
import com.hazelcast.core.HazelcastInstance

class HazelCastConfigBean {

    HazelcastInstance client = null

    public HazelCastConfigBean() {
        ClientConfig clientConfig = new ClientConfig()
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:6876", "127.0.0.1:2356")
        this.client = HazelcastClient.newHazelcastClient(clientConfig)
    }

}
