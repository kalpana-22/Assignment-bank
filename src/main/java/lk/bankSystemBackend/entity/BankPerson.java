package lk.bankSystemBackend.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity(name = "Bank_Person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankPerson implements SuperEntity{
    @EmbeddedId
    private BankPersonPK pk;

    @JoinColumn(name = "bank_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Bank bank;

    @JoinColumn(name = "person_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Person person;

    public BankPerson(Integer bankId, Integer personId) {
        this.pk = new BankPersonPK(bankId, personId);
    }

    public BankPerson(BankPersonPK pk) {
        this.pk = pk;
    }
}
