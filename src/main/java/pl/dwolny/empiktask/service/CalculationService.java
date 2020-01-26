package pl.dwolny.empiktask.service;

import org.eclipse.egit.github.core.User;
		import org.springframework.stereotype.Service;

@Service
public class CalculationService {

	public double getCalculations(User user) {

		if (user.getFollowers() == 0) {
			throw new IllegalStateException("Equation error - user has no followers yet!");
		}

		return (double) 6 / (user.getFollowers() * (2 + user.getPublicRepos()));
	}

}
