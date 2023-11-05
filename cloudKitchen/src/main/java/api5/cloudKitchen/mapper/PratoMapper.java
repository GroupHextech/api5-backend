package api5.cloudKitchen.mapper;

import org.springframework.stereotype.Component;

import api5.cloudKitchen.DTO.PratoDTO;
import api5.cloudKitchen.entity.PratoEntity;

@Component
public class PratoMapper{

    public PratoEntity map(PratoDTO pratoDTO){
        PratoEntity pratoEntity = new PratoEntity();
        pratoEntity.setPraId(pratoDTO.getPraId());
        pratoEntity.setPraNome(pratoDTO.getPraNome());
        pratoEntity.setPraPrecoVenda(pratoDTO.getPraPrecoVenda());
        return pratoEntity;
    }

    public PratoDTO map(PratoEntity pratoEntity){
        PratoDTO pratoDTO = new PratoDTO();
        pratoDTO.setPraId(pratoEntity.getPraId());
        pratoDTO.setPraNome(pratoEntity.getPraNome());
        pratoDTO.setPraPrecoVenda(pratoEntity.getPraPrecoVenda());
        return pratoDTO;
    }

}