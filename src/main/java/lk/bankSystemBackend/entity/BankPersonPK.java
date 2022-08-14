package lk.bankSystemBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BankPersonPK implements SuperEntity{
    @Column(name = "bank_id")
    private Integer bankId;
    @Column(name = "person_id")
    private Integer personId;
}
