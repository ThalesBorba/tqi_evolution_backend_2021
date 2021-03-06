package tqi.analiseDeCreditoApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tqi.analiseDeCreditoApi.dto.request.CreateEmprestimoDTO;
import tqi.analiseDeCreditoApi.dto.response.ReturnEmprestimoDetailsDTO;
import tqi.analiseDeCreditoApi.entities.Emprestimo;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

        EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

        @Mapping(target = "dataDaPrimeiraParcela", source = "dataDaPrimeiraParcela",
        dateFormat = "dd-MM-yyyy")
        Emprestimo toModel(CreateEmprestimoDTO createEmprestimoDTO);

        ReturnEmprestimoDetailsDTO toDTO(Emprestimo emprestimo);

}
