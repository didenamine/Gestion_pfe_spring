package tn.uma.isamm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.uma.isamm.entities.Utilisateur;
import tn.uma.isamm.repositories.UtilisateurRepository;

@Service
public class UtilisateurDetailsService implements UserDetailsService {
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur u = utilisateurRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur avec l'email " + email));
		return User.withUsername(u.getEmail())
				.password(u.getMotDePasse())
				.roles(u.getRole().name())
				.build();
	}
}
