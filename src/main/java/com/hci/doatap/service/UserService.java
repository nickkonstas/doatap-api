package com.hci.doatap.service;

import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Role;
import com.hci.doatap.model.UserPersonalInfo;
import com.hci.doatap.model.vo.UpdateEmail;
import com.hci.doatap.model.vo.UpdatePassword;
import com.hci.doatap.model.vo.UserVo;
import com.hci.doatap.repository.PersonalInfoRepository;
import com.hci.doatap.repository.RoleRepository;
import com.hci.doatap.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserService implements UserDetailsService{

    private UserRepository userRepository;
    private PersonalInfoRepository personalInfoRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PersonalInfoRepository personalInfoRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.personalInfoRepository = personalInfoRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User not found in the database");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        // Spring security user
        return new User(appUser.getEmail(), appUser.getPassword(), authorities);
    }

    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String email, String roleName) {
        AppUser user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public AppUser getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public AppUser getUser(Long id) {
        AppUser appUser = userRepository.findById(id).orElse(new AppUser());
        return appUser;
    }

    public UserVo login(AppUser appUser) {
        AppUser returnedAppUser = userRepository.findByEmailAndPassword(appUser.getEmail(), appUser.getPassword());
        if (returnedAppUser == null) {
            return null;
        }
        return new UserVo(returnedAppUser);
    }

    public UserVo profile(String email) {
        AppUser returnedAppUser = userRepository.findByEmail(email);
        if (returnedAppUser == null) {
            return null;
        }
        return new UserVo(returnedAppUser);
    }

    public boolean emailExist(UpdateEmail emailForm) {
        String newEmail = emailForm.getNewEmail();
        AppUser existingAppUser = userRepository.findByEmail(newEmail);
        if (existingAppUser != null)
            return true;
        return false;
    }

    public boolean validPass(UpdatePassword passwordForm) {
        String oldPass = passwordForm.getOldPass();
        String email = passwordForm.getEmail();

        AppUser existingAppUser = userRepository.findByEmailAndPassword(email, oldPass);
        if (existingAppUser != null)
            return true;
        return false;
    }

    public UserVo updateEmail(UpdateEmail emailForm) {
        String oldEmail = emailForm.getOldEmail();
        String newEmail = emailForm.getNewEmail();

        AppUser returnedAppUser = userRepository.findByEmail(oldEmail);
        if (returnedAppUser == null) {
            return null;
        }
        // Here maybe check if the new email is already used
        returnedAppUser.setEmail(newEmail);

        userRepository.save(returnedAppUser);
        return new UserVo(returnedAppUser);
    }

    public UserVo updatedPassword(UpdatePassword pass) {
        String email = pass.getEmail();
        String newPass = pass.getNewPass();

        AppUser returnedAppUser = userRepository.findByEmail(email);
        if (returnedAppUser == null) {
            return null;
        }

        returnedAppUser.setPassword(newPass);
        userRepository.save(returnedAppUser);
        return new UserVo(returnedAppUser);
    }

    public UserPersonalInfo getPersonalInfo(Long id) {
        AppUser appUser = userRepository.getById(id);
        return appUser.getUserDetails();
    }

    public UserPersonalInfo savePersonalInfo(UserPersonalInfo userPersonalInfo) {
        userPersonalInfo = personalInfoRepository.save(userPersonalInfo);
        return userPersonalInfo;
    }

}
