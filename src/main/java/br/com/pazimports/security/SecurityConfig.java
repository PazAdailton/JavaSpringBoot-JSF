package br.com.pazimports.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Desabilita CSRF (opcional para APIs)
            .authorizeHttpRequests(auth -> auth
                // Libera recursos estáticos e páginas públicas
                .requestMatchers(
                    "/",
                    "/index.jsf",
                    "/jakarta.faces.resource/**",  // Recursos do JSF (CSS, JS, etc.)
                    "/resources/**",               // Pasta de recursos estáticos
                    "/static/**",                 // Outros recursos estáticos
                    "/publica.jsf"                // Página pública (se existir)
                ).permitAll()
                // Todas as outras requisições exigem autenticação
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                //.loginPage("/login.jsf")          // Página de login personalizada
                .defaultSuccessUrl("/cliente.jsf") // Redirecionamento pós-login
                .failureUrl("/login.jsf?error=true") // URL em caso de falha
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login.jsf?logout") // URL pós-logout
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user1").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("admin").roles("ADMIN").build());
        return manager;
    }
}