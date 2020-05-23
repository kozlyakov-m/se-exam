
1. Создатть пустой проект - 5 мин
2. Подключить зависимости для сервлетов, guice, h2db, flyway, hibernate - 5 мин
3. Подключить плагин war и настроить stage task для war deploy - 5 мин
4. Создать HelloServlet - 5 мин
5. Создать web.xml - 5 мин
6. Создать GuiceServletModule и GuiceServletConfig - 5 мин
7. Подготовить Procfile - 5 мин

8. Создать миграцию с тремя таблицами: - 10 мин
    departments (id, department, tel)
    employees (id, name, departmentId)
    tel_numbers (id, tel, employeeId)
9. Создать соответсвующие сущности - 15 мин

9. Создать DepartmentServlet и EmployeeServlet - 10 мин
10. Создать DepartmentDao, EmployeeDao, TelDao - 10 мин
11. Добавить в DepartmentDao методы getAll и findById - 15 мин
12. Создать миграцию с тестовыми данными - 15 мин
13. Добавить тесты методов getAll и findById - 15 мин

14. Добавить в EmployeeDao поиск по id и по departmentId - 15 мин
15. Добавить вывод полученных данных в сервлетах - 15 мин
17. Написать в TelDao findByEmployeeId - 15 мин
16. В EmployeeServlet добавить вызов findByEmployeeId, добаивть телефоны к response - 15 мин
18. В дао классы добавить методы create, update, delete -15 
19. Подключить Gson - 20 мин
