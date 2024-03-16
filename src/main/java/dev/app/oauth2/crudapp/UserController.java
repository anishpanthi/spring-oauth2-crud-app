package dev.app.oauth2.crudapp;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@CrossOrigin(
    origins = {"https://login.microsoftonline.com", "http://localhost:4200"},
    maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

  private final ClientRegistration clientRegistration;

  private final UserRepository userRepository;

  public UserController(ClientRegistrationRepository clientRegistrationRepository,
      UserRepository userRepository) {
    this.clientRegistration = clientRegistrationRepository.findByRegistrationId("azuread");
    this.userRepository = userRepository;
  }

  @GetMapping("/user")
  public ResponseEntity<?> getUser(@AuthenticationPrincipal OAuth2User user) {
    if (user == null) {
      return new ResponseEntity<>("", HttpStatus.OK);
    } else {
      return ResponseEntity.ok().body(user.getAttributes());
    }
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout(HttpServletRequest request) {
    // send logout URL to client so they can initiate logout
    var issuerUri = clientRegistration.getProviderDetails().getIssuerUri();
    var originUrl = request.getHeader(HttpHeaders.ORIGIN);
    Object[] params = {issuerUri, clientRegistration.getClientId(), originUrl};

    var logoutUrl =
        "https://login.microsoftonline.com/1b286c40-c2fd-46d5-a553-b6502b89f42d/oauth2/v2.0/logout";
    request.getSession().invalidate();
    return ResponseEntity.ok().body(Map.of("logoutUrl", logoutUrl));
  }

  @GetMapping("/all/users")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok().body(userRepository.findAll());
  }
}
