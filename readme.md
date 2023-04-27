

# Creado por: 
    * Andrés Ruiz
    * Esteban Bustamante
    * Jose palencia

# Versiones presentes en el proyecto
    * JAVA 17
    * SPRINGBOOT: 3.0.6
    * Gesto de depenencias con MAVEN    

# Confirguración de conexió a BD

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/{TU BASE DEDATOS}?useUnicode=true&serverTimezone=UTC
    spring.datasource.username={TU USUARIO}
    spring.datasource.password=TU CONTRASEÑA
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
