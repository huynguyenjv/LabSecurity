package fit.hutech.labsecurity.RequestEntities;

import fit.hutech.labsecurity.entites.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class UserCreate {

    private String id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
    private boolean isDeleted;
    private Role role;
}
