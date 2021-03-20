# angularAndSprngBt
instructions: 
1)run the angular app for the frontend: </br>
a)Go into the root of the angular directory</br> b)install the node modules with npm install command</br> c)use the command line and type: ng serve (hit enter)</br> d) navigate in browser to http://127.0.0.1:4200/items
</br>
2)run the server:</br> 
a)Go to the root of the spring-boot directory (spBtInventory) b)use the command line for the 3 following commands:</br>
./mvnw clean </br>
./mvnw package </br>
./mvnw spring-boot:run </br>
*if you get "permission denied for run ./mvnw" use the command: chmod +x mvnw </br>
*if the above does not work install maven, and issue the above commands with mvn instead of ./mvnw</br>

h2 database:</br>
c)you need to have h2 configured with user name or password or you might get this or a simliar error:</br>
org.h2.jdbc.JdbcSQLInvalidAuthorizationSpecException: Wrong user name or password [28000-200]</br>
d)change the name and password to match the configuration in application.properties file in resources folder</br>
e)if you have h2+spring boot running go to console here:</br>
http://localhost:8080/h2-console/</br>
f)default credentials tend to be: user =sa, passowrd left blank</br>
</br>
swagger API exposure:</br>
http://localhost:8080/swagger-ui/index.html</br>
</br>
docker creation steps:</br>
create the images from the dockerfiles	</br>
$docker run --name new-container-name1 -d -p 4200:80 image1</br>
$docker run --name new-container-name2 -d -p 8080:8080 image2</br>
</br>
start the dockers:</br>
docker start new-container-name1</br>
docker start new-container-name2</br>

go to http://127.0.0.1:4200/</br>
you may need to reload web page after first item creation.</br>
