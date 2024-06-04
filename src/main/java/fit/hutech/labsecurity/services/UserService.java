package fit.hutech.labsecurity.services;

import fit.hutech.labsecurity.entites.Role;
import fit.hutech.labsecurity.entites.User;
import fit.hutech.labsecurity.RequestEntities.UserCreate;
import fit.hutech.labsecurity.repositories.roleRepository;
import fit.hutech.labsecurity.repositories.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final userRepository userRepository;
    @Autowired
    private final roleRepository roleRepository;

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Khong tim thay ID")
        );
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void createUser(UserCreate userCreate){
        try{
            User user = new User();
            user.setId(userCreate.getId());
            user.setUsername(userCreate.getUsername());
            user.setEmail(userCreate.getEmail());
            user.setPassword(userCreate.getPassword());
            user.setFirstName(userCreate.getFirstName());
            user.setLastName(userCreate.getLastName());
            System.out.println(userCreate.getBirthday());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(dateFormat.parse(userCreate.getBirthday()));
            user.setIsDeleted(userCreate.isDeleted());
            Role role = roleRepository.findById(userCreate.getRole().getRole_id())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            user.setRole(userCreate.getRole());
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateUser(UserCreate userCreate){
        try{
            User user = userRepository.findById(userCreate.getId()).orElseThrow(
                    () -> {
                        throw new RuntimeException("Khong tim thay ID");
                    }
            );
            user.setUsername(userCreate.getUsername());
            user.setEmail(userCreate.getEmail());
            user.setPassword(userCreate.getPassword());
            user.setFirstName(userCreate.getFirstName());
            user.setLastName(userCreate.getLastName());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(dateFormat.parse(userCreate.getBirthday()));
            user.setIsDeleted(userCreate.isDeleted());
            user.setRole(userCreate.getRole());
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteUser(String id){
        try{
            User user = userRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Khong tim thay ID")
            );
            user.setIsDeleted(true);
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
