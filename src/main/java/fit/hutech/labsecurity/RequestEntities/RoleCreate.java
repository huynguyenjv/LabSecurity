package fit.hutech.labsecurity.RequestEntities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RoleCreate {
    private Integer role_id;
    private String name;
}
