package com.fintechlabs

class Enums {

    public static enum HazelCastQueue {
        TESTQUEUE1("com.fintechlabs.queues.TestQueue1"),
        TESTQUEUE2("com.fintechlabs.queues.TestQueue2")

        public String className

        HazelCastQueue(String className) {
            this.className = className
        }
    }

}
