package com.banu.MonolitSpotify.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddMusicForArtistsRequestDto {
    @NotBlank
    @Min(1)     // veri tabanındaki id ler 1 den başlar, 0 atanamaz!!!
    Long muzikId;
    @NotBlank
    @Min(1)
    Long artistsId;

}
