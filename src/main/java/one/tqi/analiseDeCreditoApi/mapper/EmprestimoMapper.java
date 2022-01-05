package one.tqi.analiseDeCreditoApi.mapper;

import one.tqi.analiseDeCreditoApi.dto.request.ReturnEmprestimoDetailsDTO;
import one.tqi.analiseDeCreditoApi.entities.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

        EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

        @Mapping(target = "dataDaPrimeiraParcela", source = "dataDaPrimeiraParcela",
        dateFormat = "dd-MM-yyyy")
        Emprestimo toModel(ReturnEmprestimoDetailsDTO returnEmprestimoDetailsDTO);

        ReturnEmprestimoDetailsDTO toDTO(Emprestimo emprestimo);
}
