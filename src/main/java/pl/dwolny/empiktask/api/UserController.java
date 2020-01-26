package pl.dwolny.empiktask.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dwolny.empiktask.model.UserData;
import pl.dwolny.empiktask.service.UserDataService;

import java.io.IOException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserDataService userDataService;

	@GetMapping("/{login}")
	public UserData getUserData(@PathVariable String login) throws IOException {

		return userDataService.getUserData(login);
	}
}
