package com.bizns.bizneyland.web.dto;

import com.bizns.bizneyland.domain.tm.Tm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class TmCreateRequestDto {

    private Long clientSeq;
    private Long userSeq;
    private Long companyCharge;
    private LocalDateTime callDate;
    private String recipient;
    private String headcount;
    private String purpose;
    private String hopeAmount;
    private Character arrearsYn;
    private String arrearsDetail;
    private String creditStatus;
    private String hopeCallTime;
    private String memo;

    //대출 정보
    private LoanRequestDto loan;

    @Builder
    public TmCreateRequestDto(Long clientSeq, Long userSeq, Long companyCharge, LocalDateTime callDate,
                              String recipient, String headcount, String purpose, String hopeAmount,
                              Character arrearsYn, String arrearsDetail, String creditStatus,
                              String hopeCallTime, String memo, LoanRequestDto loan) {
        this.clientSeq = clientSeq;
        this.userSeq = userSeq;
        this.companyCharge = companyCharge;
        this.callDate = callDate;
        this.recipient = recipient;
        this.headcount = headcount;
        this.purpose = purpose;
        this.hopeAmount = hopeAmount;
        this.arrearsYn = arrearsYn;
        this.arrearsDetail = arrearsDetail;
        this.creditStatus = creditStatus;
        this.hopeCallTime = hopeCallTime;
        this.memo = memo;
        this.loan = loan;
    }

    public Tm toEntity() {
        return Tm.builder()
                .callDate(callDate)
                .recipient(recipient)
                .headcount(headcount)
                .purpose(purpose)
                .hopeAmount(hopeAmount)
                .arrearsYn(arrearsYn)
                .arrearsDetail(arrearsDetail)
                .creditStatus(creditStatus)
                .hopeCallTime(hopeCallTime)
                .memo(memo)
                .companyCharge(companyCharge)
                .build();
    }
}
