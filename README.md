# smmdb-api
An easy-to-use Java-API for accessing the [SMMDB-API](https://github.com/Tarnadas/smmdb/#public-api)</a> with [POJOs](https://en.wikipedia.org/wiki/Plain_old_Java_object).

### Functionalities
- Getting the server stats of SMMDB
- Getting and filtering courses from SMMDB (including Super Mario Maker 64 courses)
- Downloading the courses

### ToDo:
- Uploading of courses

### Maven
For binding in the API in your project with Maven, add these lines of code between your "**\<repositories>**" tags:
```xml
<repository>
      <id>FluentCoding-smmdb-api</id>
      <url>https://packagecloud.io/FluentCoding/smmdb-api/maven2</url>
</repository>
```
... and these between your "**\<dependencies\>**" tags:
```xml
<dependency>
      <groupId>io.fluentcoding</groupId>
      <artifactId>smmdb-api</artifactId>
      <version>LATEST</version>
</dependency>  
```

### Gradle
For binding in the API in your project with Gradle, add this:
```gradle
repositories {
      // ...
      maven {
        url "https://packagecloud.io/FluentCoding/smmdb-api/maven2"
      }
}
// ...
compile 'io.fluentcoding:smmdbapi:1.0'
```

### Documentation
To see more information about the detailed usage of this API, visit [this](https://zsuckylp.gitbook.io/workspace/) page.

### More...
For more information about the smmdb project, visit the server at https://smmdb.ddns.net.
