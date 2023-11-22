package api5.cloudKitchen.security;

import lombok.Data;

@Data
public class Login {

	private Long idUsuario;

    private String loginUsuario;

    private String senhaUsuario;

    private String autorizacao;

    private String token;

}
