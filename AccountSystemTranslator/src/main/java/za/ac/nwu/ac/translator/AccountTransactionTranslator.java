package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

public interface AccountTransactionTranslator {
    AccountTransactionDto save(AccountTransactionDto accountTransactionDto);

}
