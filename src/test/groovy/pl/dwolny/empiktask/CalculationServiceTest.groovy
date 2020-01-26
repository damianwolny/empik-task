package pl.dwolny.empiktask

import org.eclipse.egit.github.core.User
import pl.dwolny.empiktask.service.CalculationService
import spock.lang.Specification
import spock.lang.Subject

class CalculationServiceTest extends Specification {

    @Subject
    CalculationService calculationService = new CalculationService()

    def 'should calculate proper equation result'() {

        given: 'new Github user with one repo and follower'
        User user = new User()
        user.setFollowers(1)
        user.setPublicRepos(1)

        when:
        def calculations = calculationService.getCalculations(user)

        then: 'calculation result is positive and equal to 2.0'
        calculations > 0
        calculations == 2.0d
    }
}
