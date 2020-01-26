package pl.dwolny.empiktask.model;

import org.eclipse.egit.github.core.User;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class UserMapper {

	public UserData toUserData(User user, double calculations) {

		return UserData.builder()
				.id(user.getId())
				.login(user.getLogin())
				.name(user.getName())
				.type(user.getType())
				.avatarUrl(user.getAvatarUrl())
				.createdAt(user.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
				.calculations(calculations)
				.build();
	}
}
