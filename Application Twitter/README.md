# Twitter Application

<img src="./twitter.gif" width="800" height="450" />

##### Create social network application that allows an anonymous user to:
1. Tweet a message.
2. List all messages in a chronological order with the latest messages displayed first.
3. Exit the application.

The user chooses a functionality from a menu using the standard input stream (console).

##### Modify the Twitter application to use the Spring framework.

##### Modify the Twitter application to use a H2 database leveraging the Spring Data JPA technology. Include functionality for:
- Signing up (only email is stored)
- Signing in (by specifying the email)
- Signing out
- Following other twitters
- Modify the functionality for listing tweets to only include those which belong to twitters being followed by the signed in twitter.

##### Modify the Twitter application to expose all functionalities through RESTful web services.

##### Connect Twitter application with Angular 2 client

## Running application

Follow these instructions to execute the application:

```bash
$ mvn clean install -X
$ cd backend/
$ mvn spring-boot:run
```

The application will be accessible at [http://localhost:8080](http://localhost:8080)
