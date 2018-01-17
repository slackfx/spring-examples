package br.com.authserver.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.authserver.model.User;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if ("teste".equals(username)) {
			User user = new User();
			
			user.setId(1l);
			user.setUsername("teste");
			user.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
			user.setEnabled(true);
			user.addAuthority(new GrantedAuthority() {
				
				@Override
				public String getAuthority() {
					// TODO Auto-generated method stub
					return "ROLE_ADMIN";
				}
			});
			return user;
		}

		throw new UsernameNotFoundException("Username not found");
	}

}
