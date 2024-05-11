# Диплом на тему "..."
## Запуск
Сделать `mvn clean package` и прописать в консоль следующие команды:
1) `docker build . -f Dockerfile -t document-management` // вводится 1 раз после изменений в коде
2) `docker network create vkr_network` // вводится 1 раз
3) `docker-compose up -d` // вводится для запуска приложения

// Делается при первом запуске контейнера

Для правильной работы Minio, нужно перейти на `http://localhost:9090/login` и войти: 

1) login - adminLogin
2) password - ch3Wuetm

Далее вкладка `Buckets` -> `Create buckets` -> name - `docs`
## Остановка
Прописать в консоль `docker-compose stop`

## Доступные пользователи

|   Роль   |   Логин    |   Пароль   |
|:--------:|:----------:|:----------:|
| Директор | dirSamara  | dirSamara  |
| Директор | dirMoscow  | dirMoscow  |
| Директор | dirStPeter | dirStPeter |
|  Админ   |   admin    |   admin    |