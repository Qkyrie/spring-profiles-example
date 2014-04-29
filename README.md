spring-caching-example
======================

This is an example of how the Cache Abstraction (Since [Spring 3.1](http://docs.spring.io/spring/docs/3.1.0.M1/spring-framework-reference/html/cache.html "Spring 3.1") can be used.

At this point, only a basic setup with [Spring Boot](http://projects.spring.io/spring-boot/ "Spring Boot") is shown, but in the future, more examples, including examples with more complex caching (including SPel) will be implemented as an example.

###Downloading the example
	
	git clone https://github.com/Qkyrie/spring-caching-example.git

###Running the example
	gradle bootRun

Next up, go to **localhost:8080/messages/1** to see a message. The first time, it will fetch it from a repository. The second time this is called, it will be fetched from a dedicated cache.
