import com.hazelcast1.Person
import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->
        if (Person.count == 0) {
            (0..3).each {
                Person person = new Person()
                person.firstName = "Test"
                person.lastName = "Person #${it + 1}"
                person.phoneNumber = RandomStringUtils.randomNumeric(10)
                person.emailAddress = "person${it + 1}@email.com"
                person.save(flush: true)
            }
        }
    }
    def destroy = {
    }
}
