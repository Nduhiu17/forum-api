# Forum

#### Description

Forum is a web application where software developers can discuss different kind of topics regarding software development.

#### Preliquesities

Java,Spring Boot,Hibernate,Postgres

### Documentation Link

Please click [Documentation](https://app.swaggerhub.com/apis/Nduhiu17/Forum/1.0.0) to view api documentation

### Please click [Hosted Link](https://forum.destinyinvestments.co.ke/#/) to access and interact with the website.

#### Getting Started:

> Clone the repo by: \$ git clone https://github.com/Nduhiu17/forum-api.git

> Navigate to project directory by: \$ cd forum-api

> Open the project with your favorite IDE

> Run the project by: \$ mvn forum-api

### Endpoints

| METHOD | ENDPOINT                                          | DESCRIPTION                            |
| ------ | ------------------------------------------------- | -------------------------------------- |
| POST   | /api/v1/forums                                    | End create a forum topic               |
| GET    | /api/v1/forums                                    | End get all forums topics              |
| GET    | /api/v1/forums/<int:id>                           | Endpoint to get a forum topic by id    |
| PUT    | /api/v1/forums/<int:id>                           | Endpoint to update a forum topic       |
| DELETE | /api/v1/forums/<int:id>                           | Endpoint to delete a forum topic       |
| POST   | /api/v1/forums/<int:forum_id>/posts               | Endpoint to create a post to a topic   |
| GET    | /api/v1/forums/<int:forum_id>/posts               | Endpoint to get all posts of a topic   |
| GET    | /api/v1/forums/<int:forum_id>/posts/<int:post_id> | Endpoint to get a post by id           |
| PUT    | /api/v1/forums/<int:forum_id>/posts/<int:post_id> | Endpoint to update a post              |
| DELETE | /api/v1/forums/<int:forum_id>/posts/<int:post_id> | Endpoint to delete a post              |
| POST   | /api/v1/posts/<int:post_id>/comments              | Endpoint to create a comment to a post |

### Author

> Antony Nduhiu
