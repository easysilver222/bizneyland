package com.bizns.bizneyland.web.dto;

import com.bizns.bizneyland.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MemberSaveRequestDto {

    // 회원 이름
    private String name;
    // 닉네임
    private String nickname;
    // 생년월일
    private String birth;
    // 성별
    private String gender;
    // 휴대폰 번호
    private String mobile;
    // 직급 및 직책
    private String grade;
    // 활동 지역
    private String workingArea;
    // 이메일
    private String email;
    // 팩스 번호
    private String fax;
    // 프로필 사진
    private Long profileFileSeq;
    // 소속 회사 일련 번호
    private Long companyId;

    @Builder
    public MemberSaveRequestDto(String name, String nickname, String birth, String gender,
                                String mobile, String grade, String workingArea, String email,
                                String fax, Long profileFileSeq, Long companyId) {
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.mobile = mobile;
        this.grade = grade;
        this.workingArea = workingArea;
        this.email = email;
        this.fax = fax;
        this.profileFileSeq = profileFileSeq;
        this.companyId = companyId;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .birth(birth)
                .gender(gender)
                .mobile(mobile)
                .grade(grade)
                .workingArea(workingArea)
                .email(email)
                .fax(fax)
                .profileFileSeq(profileFileSeq)
                .companyId(companyId)
                .build();
    }
}
