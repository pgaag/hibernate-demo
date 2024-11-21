# Demo-Project

**This is a demo project for a computer science course at the Technical University of Applied Sciences Augsburg called "Programmieren mit Datenbanken".**

Some people had some issues generating the entities with the IntelliJ. 
This project should have that resolved. The entities are already present. 

If you want to test if everything works you can delete the entities and generate them again.
You will need to enter the generate menu a second time to generated the missing columns which are foreign keys.
This will generate duplicates which you will have to remove.
One more error will appear, due to a datatype mismatch for the ZIP-Code. 
If you have any issues you can always refer to the already present generated entities.

For the project to run there needs to be a `database.properties` file created under `./src/main/resources`.
The content should be:
```
db.url=jdbc:postgresql://pg-stud.informatik.tha.de:5432/YOUR_DATABASE_NAME?escapeSyntaxCallMode=callIfNoReturn
db.user=YOUR_USER
db.password=YOUR_PW
```

Also update two columns in the `persistence.xml`:
```
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://pg-stud.informatik.tha.de:5432/YOUR_DATABASE_NAME?escapeSyntaxCallMode=callIfNoReturn"/>
<property name="jakarta.persistence.jdbc.user" value="YOUR_USER_NAME"/>
``` 

If you want to change the verbosity of the logging you can update that in the `log4j2.xml` under `<Root level="debug">`
