package pl.dwolny.empiktask.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserData {

	private int id;
	private String login;
	private String name;
	private String type;
	private String avatarUrl;
	private LocalDate createdAt;
	private Double calculations;
}
