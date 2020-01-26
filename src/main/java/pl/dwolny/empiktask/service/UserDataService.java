package pl.dwolny.empiktask.service;

import lombok.RequiredArgsConstructor;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.UserService;
import org.springframework.stereotype.Service;
import pl.dwolny.empiktask.dao.UserStatsRepository;
import pl.dwolny.empiktask.dao.entity.UserStats;
import pl.dwolny.empiktask.model.UserData;
import pl.dwolny.empiktask.model.UserMapper;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserDataService {

	private final UserService userService = new UserService();
	private final UserMapper userMapper;
	private final CalculationService calculationService;
	private final UserStatsRepository repository;

	@Transactional
	public UserData getUserData(String login) throws IOException {

		User user = userService.getUser(login);
		double calculations = calculationService.getCalculations(user);
		updateUserRequestCount(login);

		return userMapper.toUserData(user, calculations);
	}

	private void updateUserRequestCount(String login) {

		UserStats userStats = repository.findUserStatsByLogin(login);
		userStats.setRequestCount(userStats.getRequestCount() + 1);
		repository.save(userStats);
	}
}
