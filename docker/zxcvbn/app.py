import sys
from zxcvbn import zxcvbn

# récupération du mot de passe envoyé par Docker
password = sys.argv[1] if len(sys.argv) > 1 else ""

# analyse
result = zxcvbn(password)

# score de 0 (très faible) à 4 (très fort)
print(result["score"])