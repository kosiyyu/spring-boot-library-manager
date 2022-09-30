
# Library-manager
Spring boot CRUD API project enabling basic management in library. Contains:

- Adding, deletion and patching class book and author. The program is using mainly Thymeleaf template engine and bootstrap to handle front-end
- Back-end and front-end validation
- User class, where the encrypted password is saved encrypted in database
- Roles (Admin, User), authorized requests
- Database and many-to-many relationship
- Error handling




## Deployment

To deploy and run

```bash
  git clone https://github.com/Kosiyyu/spring-boot-library-manager
```
When you run the project for the first time, you can create an administrator account under url /register.
Then you should comment line 41 at spring-boot-library-manager/src/main/java/com/proj/library/security/WebSecurityConfiguration.java:

```bash
  .antMatchers("/register","register/**").hasAnyAuthority("ADMIN")
```
The above line prevents users and administrators from registering for everyone except administrators.

Work in progress... ;))



## Images
- [Project screenshots](https://github.com/Kosiyyu/images/tree/main/spring-boot-library-manager)


Work in progress... ;))
## Author

- [@Kosiyyu](https://github.com/Kosiyyu)

