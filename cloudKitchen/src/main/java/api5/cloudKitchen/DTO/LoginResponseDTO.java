package api5.cloudKitchen.DTO;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private String logUsername;
    private String logPassword;
    private PermissaoDTO pmsId;

}
