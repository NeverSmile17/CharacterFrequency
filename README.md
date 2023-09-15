Документация по запуску и формату входных/выходных параметров для REST API, вычисляющего частоту встречи символов по заданной строке:

## Запуск приложения

1. Убедитесь, что у вас установлены Java 8+ и Spring Boot 2+.
2. Склонируйте проект с помощью команды `git clone ` или загрузите исходный код в архиве.
3. Откройте проект в вашей IDE.
4. Запустите приложение, используя класс `DemoApplication`.
5. Приложение будет запущено на порту 8080.

## Формат входных параметров

- Метод: POST
- Путь: /api/frequency
- Тело запроса: JSON объект с полем "input", содержащим заданную строку

Пример запроса:
POST /api/frequency
Content-Type: application/json

abbcccdddd

## Формат выходных параметров

- Тело ответа: JSON объект с полем "frequency", содержащим массив объектов, каждый из которых представляет символ и его частоту встречи в заданной строке

Пример ответа:
HTTP/1.1 200 OK
Content-Type: application/json

{
  {"symbol": "d", "count": 4},
  {"symbol": "c", "count": 3},
  {"symbol": "b", "count": 2},
  {"symbol": "a", "count": 1}
}

Пожалуйста, обратите внимание, что результаты отсортированы по убыванию количества вхождений символа в заданную строку.

Теперь вы можете запустить приложение и использовать REST API для вычисления частоты встречи символов по заданной строке.