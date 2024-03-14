@echo off

rem Установка переменных окружения
set "JAVA_HOME=C:\Users\OlegFighter\.jdks\openjdk-21.0.2"

rem Компиляция проекта
mvn clean compile

rem Запуск тестов
mvn test

rem Выход с кодом ошибки, если тесты не прошли
if %ERRORLEVEL% NEQ 0 exit /b 1

rem Выход с кодом успеха
exit /b 0