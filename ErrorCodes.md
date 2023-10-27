# UYGULAMA İÇİ HATA KODLARI

## Yazım Şekli

    X X X X
    | | | |
    | | | ----------- Hata Şekli
    | | ------------- Hata Türü
    | --------------- İşlev No
    ----------------- Katman No

### Hata Türü 1XXX -> Servis Katmanı

    1001 -> User Profile Şifre Uyuşmazlığı Sorunu
Kullnıcı ...  end pointine istek gönderir. Gönderdiği parametrelerde, 
şifreler bir birine uyuşmuyor ise uygulama bu hatayı fırtlatır ve kayıt başarısız olur