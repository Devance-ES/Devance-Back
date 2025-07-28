# reiniciar-container.ps1
# Script para reiniciar o container do Docker facilmente

# Parar e remover containers, redes e volumes
Write-Host "Stopping and removing containers, networks, and volumes..."
docker-compose down --remove-orphans

# Reconstruir e iniciar os containers
Write-Host "Rebuilding and starting containers..."
docker-compose up --build
