package api5.cloudKitchen.DTO;

import api5.cloudKitchen.entity.PermissaoEntity;
import lombok.Data;

@Data
public class LoginDTO {

    private String logUsername;
    private String logPassword;
    private PermissaoEntity pmsId;

}
