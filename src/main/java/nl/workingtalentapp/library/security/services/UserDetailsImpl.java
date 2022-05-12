package nl.workingtalentapp.library.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.workingtalentapp.library.domein.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String username;

  private String email;

  @JsonIgnore
  private String password;

  private String phoneNumber;
  private String functie;
  private String photo;
  private String linkedinURL;

    private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String name, String username, String email, String password, String phoneNumber, String functie, String photo, String linkedinURL,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.functie = functie;
    this.photo = photo;
    this.linkedinURL = linkedinURL;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),
        user.getName(),
        user.getUsername(), 
        user.getEmail(),
        user.getPassword(),
        user.getPhoneNumber(),
        user.getFunctie(),
        user.getPhoto(),
        user.getLinkedinURL(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getFunctie() {
    return functie;
  }

  public String getPhoto() {
    return photo;
  }

  public String getLinkedinURL() {
    return linkedinURL;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
