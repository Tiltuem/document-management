# Диплом на тему "..."
## Запуск
Сделать `mvn clean package` и прописать в консоль следующие команды:
1) `docker build . -f Dockerfile -t document-management`
2) `docker network create vkr_network`
3) `docker-compose up -d`
## Остановка
Прописать в консоль `docker-compose stop`


