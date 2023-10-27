package com.banu.MonolitSpotify.dto.request;

import com.banu.MonolitSpotify.utility.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SaveUserProfileRuquestDto {
    @NotBlank(message = "Kullanıcı adını boş geçemezsiniz")
    @Size(min=3,max = 64)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=\\S+$).{3,}$",
            message = "Kullanıcı adı için sadece küçük garf ve rakam girilmelidir"
    )
    String userName;

    @Email(message = "Lütfen geçerli bir e-mail adresi giriniz")
    String email;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.,?@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre karmaşıklığı en az 1 büyük 1 küçük harf olmalı, en az bir rakam ve özel karakter içermelidir"
    )
    @Size(min = 8, max = 128)
    String password;

    //uyelik yaparken sifre iki kere girdirilir
    String rePassword;
    UserType userType;
    String resimUrl;



}
