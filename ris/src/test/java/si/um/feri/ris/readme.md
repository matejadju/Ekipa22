# 🧪 Testni razred MizaControllerTest

Ta projekt vsebuje JUnit 5 teste za preverjanje delovanja kontrolerja `MizaController` v **Spring Boot** aplikaciji.
Testi preverjajo osnovne CRUD operacije nad entiteto Miza in uporabljajo servisni ter repozitorijski sloj aplikacije.

---

## 📋 Opis testnega razreda

**Razred:** `MizaControllerTest`
**Lokacija:** `src/test/java/si/um/feri/ris/MizaControllerTest.java`

Testi uporabljajo naslednje Spring Boot oznake:

`@SpringBootTest` — zaženemo celoten Spring kontekst brez spletnega strežnika.

`@Transactional` — po vsakem testu se spremembe v bazi samodejno povrnejo.

`@BeforeEach` — pred vsakim testom izbriše vse zapise iz baze.

## ⚙️ Kako zagnati teste

### ✅ Iz IDE-ja

V IntelliJ IDEA, Eclipse ali VS Code:

1. Odpri razred `MizaControllerTest`

2. Klikni Run ▶️

### ✅ Iz ukazne vrstice

Zaženi naslednji Maven ukaz:
```bash
mvn test
```

Spring Boot bo samodejno inicializiral testni kontekst in izvedel vse teste.

---

## 🧩 Testirane funkcionalnosti
### 1. `contextLoads()`

Preveri, da so vsi osnovni Spring beani pravilno naloženi:

- MizaController

- MizaService

- MizaRepository

### 2. `testGetAll()`

**Opis:** Preverja metodo `getALL()` v kontrolerju.

**✅ Pozitiven scenarij:** Doda dve mizi v bazo in preveri, ali sta obe vrnjeni v seznamu.

**❌ Negativen scenarij:** Ko je tabela prazna, se pričakuje prazen seznam.

### 3. `testGetById()`

**Opis:** Preverja pridobivanje posamezne mize po ID-ju.

**✅ Pozitiven scenarij:** Ustvari mizo in jo uspešno poišče po ID-ju.

**❌ Negativen scenarij:** Zahteva ID, ki ne obstaja — pričakuje se Optional.empty().

### 4. `testCreateMiza()`

**Opis:** Preverja ustvarjanje nove mize.

**✅ Pozitiven scenarij:** Ustvari novo mizo in preveri, da ji je dodeljen ID.

**❌ Negativen scenarij:** Poskusi ustvariti null objekt — pričakuje se ResponseStatusException.

### 5. `testUpdateMiza()`

**Opis:** Preverja posodobitev obstoječe mize.

**✅ Pozitiven scenarij:** Spremeni status obstoječe mize in preveri, ali je sprememba shranjena.

**❌ Negativen scenarij:** Poskusi posodobiti mizo z ID-jem, ki ne obstaja — pričakuje se izjema.

### 6. `testDeleteMiza()`

**Opis:** Preverja brisanje obstoječe mize.

**✅ Pozitiven scenarij:** Izbriše obstoječo mizo in preveri, da je ni več v bazi.

**❌ Negativen scenarij:** Poskusi izbrisati mizo z neobstoječim ID-jem — pričakuje se izjema.

## 🧠 Ključne opombe

- Testi so izolirani zaradi uporabe `@Transactional`, zato ne vplivajo trajno na podatkovno bazo.

- Vsaka metoda vsebuje **pozitivne** in **negativne** scenarije.

- `System.out.println` izpisi omogočajo enostavno sledenje poteku testa v konzoli.

## 🧰 Uporabljene tehnologije

- Java 17+

- Spring Boot

- JUnit 5

- Maven

- Spring Data JPA