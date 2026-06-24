
# 🔐 Password CLI Generator (Java + Docker)

## 📌 Description

Ce projet est un outil en ligne de commande développé en Java 21 permettant de générer des mots de passe sécurisés et d’évaluer leur robustesse.

L’originalité du projet repose sur l’intégration d’un outil externe via Docker (zxcvbn) pour analyser la force des mots de passe.

---

## ⚙️ Fonctionnalités

- Génération de mots de passe personnalisés
- Choix de la longueur
- Choix des types de caractères (majuscule, minuscule, chiffres, symboles)
- Mode rafale (génération multiple)
- Analyse de robustesse (Très faible → Très fort)
- Interface CLI (ligne de commande)

---

## 🧱 Architecture

### Java (Application principale)
- CLI (gestion des arguments)
- Génération de mots de passe
- Affichage des résultats

### Docker (Analyse externe)
- Conteneur Python avec zxcvbn
- Analyse des mots de passe
- Retour d’un score (0 à 4)

### Communication
Java utilise `ProcessBuilder` pour exécuter Docker et récupérer le score.

---

## 🐳 Installation Docker
Installler d'abord le Docker
```bash
docker build -t zxcvbn-check docker/zxcvbn
```
## Utilisation (EXEMPLES)
🔹 Créer d'abord un dossier nommé "out" puis compile le projet avant tout lancement
Linux
```bash
javac -d out $(find src/main/java -name "*.java")
```
Windows
```bash
mkdir out
javac -d out (Get-ChildItem -Recurse src\main\java\com\securepass\*.java).FullName                                       
```

🧪 Tester Docker directement
```bash
docker run zxcvbn-check "Test123!"
```

🔹 Générer 1 mot de passe simple
```bash
java -cp out main.java.com.securepass.Main --length=12
```
🔹 Générer 5 mots de passe sécurisés avec symboles
```bash
java -cp out main.java.com.securepass.Main --length=16 --count=5 --symbols
```
🔹 Activer uniquement majuscules + chiffres
```bash
java -cp out main.java.com.securepass.Main --length=14 --no-lower --symbols
```
🔹 Exemple de sortie
```bash
🔐 PASSWORD GENERATOR

→ xP9!kLm2ZqT8  [Fort]
→ a8#Qw9LpXz12  [Très fort]
→ mN4@kP9vBx01  [Moyen]

```

❓ Help command (si tu veux aller plus loin)
```bash
java -cp out main.java.com.securepass.Main --help
```