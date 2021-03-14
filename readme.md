
instructions:
1)run the angular app for the frontend:
	a)Go into the root of the angular directory 
	b)install the node modules with npm install command
	c)use the command line and type: ng serve (hit enter)
	d) navigate in browser to http://127.0.0.1:4200/items

2)run the server:
	a)Go to the root of the spring-boot directory (spBtInventory)
	b)use the command line for the 3 following commands:
	./mvnw clean
	./mvnw package
	./mvnw spring-boot:run
	*if you get "permission denied for run ./mvnw" use the 		command: 
		chmod +x mvnw
	*if the above does not work install maven, and issue the above commands with mvn instead of ./mvnw
	
	h2 database:
	c)you need to have h2 configured with user name or password or you might get this or a simliar error:
	org.h2.jdbc.JdbcSQLInvalidAuthorizationSpecException: Wrong user name or password [28000-200]
	d)change the name and password to match the configuration in application.properties file in resources folder
	e)if you have h2+spring boot running go to console here:
	http://localhost:8080/h2-console/
	f)default credentials tend to be: user =sa, passowrd left blank
	
	swagger API exposure:
	http://localhost:8080/swagger-ui/index.html
	
	docker creation steps:
	create the images from the dockerfiles	
	$docker run --name inv-apps-containerx -d -p 4200:80 my-inv-image
	$docker run --name inv-server -d -p 8080:8080 sw-sw-docker
	
	start the dockers:
	docker start inv-apps-containerx
	docker start inv-server
	
	go to http://127.0.0.1:4200/
	you may need to reload web page after first item creation.
	
