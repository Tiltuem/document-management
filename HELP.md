# Диплом на тему "..."
## Запуск
Сделать `mvn clean package` и прописать в консоль следующие команды:
1) `docker build . -f Dockerfile -t document-management` // вводится 1 раз после изменений в коде
2) `docker network create vkr_network` // вводится 1 раз
3) `docker-compose up -d` // вводится для запуска приложения
## Остановка
Прописать в консоль `docker-compose stop`


