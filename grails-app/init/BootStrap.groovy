import com.fintechlabs.Person
import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->

        (0..4).each { num ->
            Person person = new Person()
            person.firstName = "Test"
            person.lastName = "Person #${num + 1}"
            person.emailAddress = "person${num + 1}@email.com"
            person.phoneNumber = RandomStringUtils.randomNumeric(10)
            person.save(flush: true)
        }

    }
    def destroy = {
    }
}
