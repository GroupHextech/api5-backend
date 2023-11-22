package api5.cloudKitchen.mapper;

import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.PermissaoDTO;
import api5.cloudKitchen.entity.PermissaoEntity;

@Component
public class PermissaoMapper {

    public PermissaoEntity map(PermissaoDTO permissaoDTO) {

        PermissaoEntity permissaoEntity = new PermissaoEntity();
        permissaoEntity.setPmsId(permissaoDTO.getPmsId());
        return permissaoEntity;

    }

    public PermissaoDTO map(PermissaoEntity permissaoEntity) {

        PermissaoDTO permissaoDTO = new PermissaoDTO();
        permissaoDTO.setPmsId(permissaoEntity.getPmsId());
        return permissaoDTO;

    }

}
