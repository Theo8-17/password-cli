FROM python:3.11-slim

WORKDIR /app

# installation dépendance
RUN pip install zxcvbn

# copie du script
COPY app.py .

# exécution directe avec argument
ENTRYPOINT ["python", "app.py"]