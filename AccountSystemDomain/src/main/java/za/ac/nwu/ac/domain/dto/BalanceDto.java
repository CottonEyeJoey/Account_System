package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Balance;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Balance",description = "A DTO representing the Balance")
public class BalanceDto implements Serializable {

    private static final long serialVersionUID = 8732924396956507429L;

    private Long memberId;
    private String accountTypeMnemonic;
    private Long amount;

    public BalanceDto() {
    }

    public BalanceDto(Long memberId, String accountTypeMnemonic, Long amount) {
        this.memberId = memberId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.amount = amount;
    }

    public BalanceDto(Balance balance){
        this.memberId = balance.getMemberId();
        this.accountTypeMnemonic = balance.getAccountType().getMnemonic();
        this.amount = balance.getAmount();
    }

    @JsonIgnore
    public Balance buildBalance(AccountType accountType){
        return new Balance(this.getMemberId(),accountType,this.getAmount());
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceDto that = (BalanceDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountTypeMnemonic, amount);
    }

    @Override
    public String toString() {
        return "BalanceDto{" +
                "memberId=" + memberId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", amount=" + amount +
                '}';
    }
}
