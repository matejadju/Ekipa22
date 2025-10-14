# 🌃 Maribor ponoči

**Maribor ponoči** je informacijska platforma, namenjena ljubiteljem nočnega življenja v Mariboru.  
Aplikacija omogoča pregled, iskanje, rezervacijo in ocenjevanje nočnih dogodkov, klubov ter barov na enem mestu.

---

## 🧩 Tehnologije

### Frontend
- ⚛️ **React**
- React Router
- Axios (za komunikacijo z backendom)
- Tailwind CSS ali Material UI (za oblikovanje uporabniškega vmesnika)

### Backend
- ☕ **Spring Boot**
- Spring Web, Spring Security, Spring Data JPA
- MySQL podatkovna baza
- Hibernate ORM

---

## Navodila za nameščanje 

### Backend
1. Klonirajte repozitorij:
```bash
  git clone "https://github.com/matejadju/Ekipa22.git"
```
2. Prepričajte se, da imate nameščen Java 11+ in MySQL.
3. Ustvarite MySQL bazo podatkov z imenom ris
4. Zaženite aplikacijo frontend
```bash
  mvn spring-boot:run
```

### Frontend
1. Pojdite v direktorij frontend
```bash
  cd frontend
```
2. Namestite odvisnosti
```bash
  npm install
```
3. Zaženite React aplikacijo
```bash
  npm start
``` 
