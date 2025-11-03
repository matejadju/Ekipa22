# Poročilo o napaki – API `/odobren`

## 🔹 Osnovne informacije
- **Vloga:** Uporabnik (frontend aplikacije)
- **Endpoint:** `GET /odobren`
- **Status:** Napaka 500 – Internal Server Error
- **Prioriteta:** Visoka

---

## 🔹 Opis napake
Pri nalaganju seznama dogodkov iz API-ja pride do strežniške napake.  
Namesto da se prikaže seznam dogodkov, aplikacija prejme napako 500.  
Zaradi tega uporabnik ne vidi nobenih podatkov o odobrenih dogodkih.

---

## 🔹 Koraki za ponovitev
1. Zaženi backend aplikacijo (Spring Boot).
2. Pošlji `GET` zahtevo na naslov `http://localhost:8080/odobren` (npr. v Postmanu).
3. Opazuj odziv strežnika.

---

## 🔹 Pričakovano vedenje
Strežnik bi moral vrniti status **200 OK** in JSON seznam odobrenih dogodkov iz baze podatkov.

---

## 🔹 Dejanska obnašanje
Strežnik vrne status **500 Internal Server Error** in naslednje sporočilo:
java.lang.RuntimeException: Simulirana napaka v strežniku


---

## 🔹 Možen vzrok
V kontrolerju se namerno sproži izjema (`RuntimeException`), zaradi katere metoda ne vrne rezultata in pride do napake 500.

---

## 🔹 Predlog rešitve
Odstraniti vrstico, ki povzroča izjemo, oziroma pravilno obravnavati napake:
```java
@GetMapping("/odobren")
public List<Dogodek> findAllByOdobren() {
    return dogodekService.findAllByOdobren();
}

