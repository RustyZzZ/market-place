package diachuk.project.marketplace.components;

import diachuk.project.marketplace.entity.security.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtils {
	public String generateJwtToken(Authentication authentication) {
		var principal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				   .setSubject(principal.getUsername())
				   .setIssuedAt(new Date())
				   .setExpiration(new Date(new Date().getTime()+10000000))
				   .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
				   .compact();
	}

	public String getUsernameFromJwtToken(String token) {
		return Jwts.parser()
				   .setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS512))
				   .parseClaimsJwt(token)
				   .getBody()
				   .getSubject();
	}

	public boolean validate(String token){
		try{
			Jwts.parser()
				.setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS512))
				.parseClaimsJwt(token);
			return true;
		}catch (Exception e){

			e.printStackTrace();
			return false;
		}
	}

}
