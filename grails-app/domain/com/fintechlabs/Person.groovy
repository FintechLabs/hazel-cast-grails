package com.fintechlabs

class Person implements Serializable {

    private static final long serialversionUID = 129348938L

    String firstName
    String lastName
    String emailAddress
    String phoneNumber
    Date dateCreated
    Date lastUpdated
    String uniqueId = UUID.randomUUID().toString()

}
