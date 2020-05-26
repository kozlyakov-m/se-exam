## [Телефонный справочник](https://se-exam.herokuapp.com/)  
[![Build Status](https://travis-ci.org/kozlyakov-m/se-exam.svg?branch=master)](https://travis-ci.org/kozlyakov-m/se-exam) 
[![Heroku App Status](http://heroku-shields.herokuapp.com/se-exam)](https://se-exam.herokuapp.com)

Задание  
*Напишите приложение – телефонный справочник предприятия. Иерархия 2 уровня: отдел – сотрудник. У отдела может быть свой телефон, у сотрудника телефон может быть внутренний и внешние сотовые, домашние, телефон для связи в критических ситуациях, и т.д. В справочнике можно редактировать все сущности: сотрудники, отделы, списки. Должна быть возможность различных поисков: по имени сотрудники, по его номеру и т.д.*

[План](ROADMAP.md)

Приложение представляет собой REST API для телефонного справочника.

Примеры Get запросов:  
[Все отделы](https://se-exam.herokuapp.com/departments)  
[Отдел по id](https://se-exam.herokuapp.com/departments?id=2)  
[Все сотрудники](https://se-exam.herokuapp.com/employees)  
[Сотрудник по id](https://se-exam.herokuapp.com/employees?id=1)  
[Сотрудники отдела с id 1](https://se-exam.herokuapp.com/employees?department_id=1)  
[Сотрудник по номеру телефона](https://se-exam.herokuapp.com/employees?tel=8902737)  

Примеры Post-запросов

-Uri 'https://se-exam.herokuapp.com/departments'
-Method 'POST'  
-Body  
{  
"department":"New department",  
"tel":"1234"  
}  
  
-Uri 'https://se-exam.herokuapp.com/employees'
-Method 'POST'  
-Body  
{   
"name": "Employee Test",  
"departmentId":"1",  
"tel": [  
 "12345678",  
 "987654329",  
 "112"  
]  
} 

Часть функций доступна через [веб-интерфейс](https://se-exam.herokuapp.com/), написанный на React
