package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

public interface AccountTransactionTranslator {
    AccountTransactionDto save(AccountTransactionDto accountTransactionDto);

}
