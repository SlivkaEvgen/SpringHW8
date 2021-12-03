<img width="1680" alt="Снимок экрана 2021-12-03 в 15 39 13" src="https://user-images.githubusercontent.com/79520449/144611849-b1cca238-c5ea-410f-bce7-9e8f2b8083bf.png">



# Spring Market Application
ADD to Application.properties:

DB_USERNAME = {YOUR_DB}

DB_PASSWORD = {YOUR_PASSWORD}

DB_URL = {YOUR_DB_URL}
#for example:

DB_USERNAME = root

DB_PASSWORD = super_password

DB_URL = jdbc:postgresql://localhost:5432/MYSQL_DB


[comment]: <README.md> (before the start of application you have to add environment variables:)

[comment]: </README.md> (  DB_USERNAME - prod)

[comment]: </README.md> (  DB_PASSWORD - password of user)

[comment]: </README.md> (  DB_URL - database URL)

[comment]: </README.md> (for example:)

[comment]: </README.md> (  export DB_USERNAME=prod)

[comment]: </README.md> (  export DB_PASSWORD=super_password)

[comment]: </README.md> (  export DB_URL=jdbc:postgresql://localhost:5432/postgres)

#coming soon

-security

-user(update/add)

-send message(error/wrong)

-validation

-убрать логику в моделях
...
