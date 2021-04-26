package com.bizns.bizneyland.web.dto;

import com.bizns.bizneyland.domain.client.Client;
import com.bizns.bizneyland.util.FormatUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class ClientCreateRequestDto {

    @NotEmpty(message = "회사명은 필수입니다.")
    private String companyName;
    private String contact;
    private String owner;
    private String address;
    private Character type;
    private String establishDate;
    private String sector;
    private String keyItem;

    private String[] salesYears;
    private Integer[] salesAmount;

    @Builder
    public ClientCreateRequestDto(String companyName, String contact, String owner, String address,
                                  Character type, String establishDate, String sector, String keyItem,
                                  String[] salesYears, Integer[] salesAmount) {
        this.companyName = companyName;
        this.contact = contact;
        this.owner = owner;
        this.address = address;
        this.type = type;
        this.establishDate = establishDate;
        this.sector = sector;
        this.keyItem = keyItem;
        this.salesYears = salesYears;
        this.salesAmount = salesAmount;
    }

    public Client toEntity() {
        return Client.builder()
                .companyName(companyName)
                .contact(contact)
                .owner(owner)
                .type(type)
                .establishDate(establishDate)
                .sector(sector)
                .address(address)
                .keyItem(keyItem)
                .build();
    }

    // 연락처는 하이픈 제거된 형태로 받아오기
    public void setContact(String contact) {
        this.contact = FormatUtil.removeHyphen(contact);
    }
}
