package fit.hutech.labsecurity.services;

import fit.hutech.labsecurity.entites.Role;
import fit.hutech.labsecurity.RequestEntities.RoleCreate;
import fit.hutech.labsecurity.repositories.roleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    @Autowired
    private final roleRepository roleRepository;

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }
    public Role getRoleById(Integer id){
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Khong tim thay ID")
        );
    }
    public void createRole(RoleCreate roleCreate){
        try{
            Role role = new Role();
            role.setRole_id(roleCreate.getRole_id());
            role.setName(roleCreate.getName());
            roleRepository.save(role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateRole(RoleCreate roleCreate){
        try{
            Role role = roleRepository.findById(roleCreate.getRole_id()).orElseThrow(
                    () -> {
                        throw new RuntimeException("Khong tim thay ID");
                    }
            );
            role.setName(roleCreate.getName());
            roleRepository.save(role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteRole(Integer id){
        try{
            Role role = roleRepository.findById(id).orElseThrow(
                    () -> {
                        throw new RuntimeException("Khong tim thay ID");
                    }
            );
            roleRepository.delete(role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
