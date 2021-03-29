package diachuk.project.marketplace.entity.security;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Role {
	@Id
	@GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	private ERole name;

	public enum ERole{
		ROLE_USER,
		ROLE_ADMIN
	}
}

