package pl.dwolny.empiktask.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dwolny.empiktask.dao.jpa.UserStatsJpaRepository;
import pl.dwolny.empiktask.dao.entity.UserStats;

@Component
@RequiredArgsConstructor
public class UserStatsRepository {

	private final UserStatsJpaRepository repository;

	public void save(UserStats userStats) {

		repository.save(userStats);
	}

	public UserStats findUserStatsByLogin(String login) {

		return repository.findByLogin(login).orElse(new UserStats(login));
	}
}
