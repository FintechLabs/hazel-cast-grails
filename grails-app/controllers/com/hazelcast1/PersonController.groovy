package com.hazelcast1

import com.hazelcast.Enums
import com.hazelcast.HazelCastConfigBean
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.ITopic

class PersonController {

    HazelCastConfigBean hazelCastConfigBean

    def index = {
        HazelcastInstance instance = hazelCastConfigBean.client
        Map<Integer, String> mapCustomers = instance.getMap("abc-test")
        mapCustomers.put(1, "Joe")
        mapCustomers.put(2, "Ali")
        mapCustomers.put(3, "Avi")

        println("Customer with key 1: " + mapCustomers.get(1))
        println("Map Size:" + mapCustomers.size())

        Queue<String> queueCustomers = instance.getQueue("customers")
        queueCustomers.offer("Tom")
        queueCustomers.offer("Mary")
        queueCustomers.offer("Jane")
        println("First customer: " + queueCustomers.poll())
        println("Second customer: " + queueCustomers.peek())
        println("Queue size: " + queueCustomers.size())

        ITopic topicOne = hazelCastConfigBean.client.getTopic(Enums.HazelCastMessagingQueueName.QUEUE_ONE.name())
        topicOne.publish(Person.first())

        ITopic topictwo = hazelCastConfigBean.client.getTopic(Enums.HazelCastMessagingQueueName.QUEUE_TWO.name())
        topictwo.publish(Person.last())

        [personList: Person.list()]
    }

}
