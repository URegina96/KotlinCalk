Kotlin Calculator - это простое и удобное приложение для выполнения базовых математических операций. Оно позволяет пользователям осуществлять арифметические вычисления, включая сложение, вычитание, умножение и деление. Пользовательский интерфейс интуитивно понятен и адаптирован для использования на мобильных устройствах.

## Функционал

- **Арифметические операции**: Поддержка операций сложения (+), вычитания (-), умножения (*) и деления (/).
- **Основные функции**:
    - Ввод чисел и операций.
    - Очистка ввода.
    - Подсчет процентов (%).
    - Вычисление квадратного корня (√).
    - Удаление последнего символа.

- **Обработка ошибок**: Приложение обрабатывает возможные ошибки, такие как неправильный ввод, и выводит соответствующее сообщение.

- **Динамическое обновление интерфейса**: Результаты вычислений сразу отображаются на экране, благодаря использованию LiveData и ViewModel.

## Технологии

- **Kotlin**: Основной язык программирования, используемый в проекте.
- **Android SDK**: Базовая платформа для разработки приложения.
- **ViewModel**: Используется для хранения и управления UI-ориентированными данными, обеспечивая их продолжительность при изменении конфигураций.
- **LiveData**: Компонент архитектуры, предоставляющий данные с возможностью реагирования на изменения, что упрощает обновление интерфейса.
- **ViewBinding**: Упрощает использование XML-разметки в коде, позволяя избежать нажатий на элементы интерфейса через findViewById(). ViewBinding автоматически создает классы привязки, которые предоставляют доступ к элементам разметки.
- **exp4j**: С библиотекой exp4j осуществляется анализ и вычисление арифметических выражений.

## Архитектура

Приложение использует архитектурный подход MVVM (Model-View-ViewModel):
- **Model**: Логика вычислений (включая выражения и обработку ошибок) реализована в классе `CalculatorViewModel`.
- **View**: XML-разметка (UI) описывает, как пользователь взаимодействует с приложением, а также как отображается результат вычислений.
- **ViewModel**: Класс `CalculatorViewModel` управляет данными и API для взаимодействия UI с моделью, обрабатывает введенные данные и возвращает результаты.

## Установка

1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/yourusername/kotincalc.git
   ```

2. Откройте проект в Android Studio.

3. Синхронизируйте проект с Gradle.

4. Запустите приложение на эмуляторе или реальном устройстве.

