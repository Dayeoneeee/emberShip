package com.example.membership.dto;

import com.example.membership.constant.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberShipDTO {

    private Long num;       //회원 읽기 등을 볼 때, pk값을 가지고 있어야함
                                //등록시에는 필요없으니, not null을 사용하지 않음

    @NotBlank(message = "이름을 꼭 써야 합니다.")
    @Size(min = 2 ,max = 10, message = "2~10글자 이내로 작성하셔야 합니다." )
    private String name;        //이름    //notblank 최소 : 2, 최대 : 10

    @NotBlank(message = "빈문자, 공백을 허용하지 않습니다. 꼭 이메일을 작성하셔야 합니다.")
    @Size(max = 50, message = "최대 50글자 이내로 작성하셔야 합니다.")
    @Email(message = "이메일 형식에 맞춰서 작성하세요")
    private String email;       //이메일   //email, 최대값은 50글자, 메시지 : 최대 50글자 이내로 작성하셔야 합니다.

    @NotBlank(message = "비밀번호는 꼭 작성하셔야 합니다.")
    @Size(min = 10, max = 16, message ="10~16 이내로 비밀번호를 작성하셔야합니다.")
    private String password;    //비밀번호  //notblank,
                                // 최소 : 10, 최대 16, 메시지 : 10~16 이내로 비밀번호를 작성하셔야합니다.

    @NotBlank(message = "주소는 꼭 작성하셔야 합니다.")
    private String address;     //주소    //notblank

    //권한
    private Role role;  //이건 어짜피 유저디테일서비스에서 직접 넣어줄 내용.
                        // 필요에 따라서 어드민 가입페이지와 일반 유저가입페이지가 분리될 수 있음
}
