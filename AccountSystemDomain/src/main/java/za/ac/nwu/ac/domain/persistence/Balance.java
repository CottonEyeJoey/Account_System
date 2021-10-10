package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "BALANCE", schema = "hr")
public class Balance implements Serializable {

    private static final long serialVersionUID = -3199417323867984916L;

    private Long memberId;
    private AccountType accountType;
    private Long amount;

    public Balance() {
    }

    public Balance(Long memberId, AccountType accountType,Long amount) {
        this.memberId = memberId;
        this.accountType = accountType;
        this.amount = amount;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_SEQ", sequenceName = "hr.MEMBER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType()
    {
        return accountType ;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "AMOUNT")
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
        Balance that = (Balance) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(accountType, that.accountType) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountType,  amount);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "memberId=" + memberId +
                ", accountType=" + accountType +
                ", amount=" + amount +
                '}';
    }
}
