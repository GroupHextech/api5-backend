package api5.cloudKitchen.DTO;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String logUsername;
    private String logPassword;
    private Long pmsId;

}
