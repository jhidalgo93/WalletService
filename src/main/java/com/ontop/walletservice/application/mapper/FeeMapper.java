package com.ontop.walletservice.application.mapper;

import com.ontop.walletservice.application.dto.fee.FeeResponse;
import com.ontop.walletservice.domain.model.fee.TransactionFee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeeMapper {


    FeeMapper INSTANCE = Mappers.getMapper(FeeMapper.class);

    FeeResponse toTransactionFeeResponse(TransactionFee transactionFee);

}
