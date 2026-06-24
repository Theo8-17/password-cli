
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

```bash
docker build -t zxcvbn-check docker/zxcvbn