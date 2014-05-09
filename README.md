Spring Profiles using Spring Boot
===

###The Code

> Note: Parts of the example code in the repository uses Java 8 features.

####Using the @Profile annotation


	@Profile("test")
	@Configuration
	public class HelloWorldTestProducer {
	    private Log LOG = 
				LogFactory
				.getLog(HelloWorldTestProducer.class);
	
	
	    @PostConstruct
	    public void init() {
	        LOG.info("test world has been produced");
	    }
	
	    @Bean(name = "helloWorld")
	    public String produceHelloWorld() {
	        return "Hello test world!";
	    }
	
	}

As you can can see, the above class is annotated with **@Configuration**. The annotation that is of utter importance for this blogpost is the **@Profile** annotation. In short, what this means is that this Configuration class will only load if the profile with name *test* is active in the current Environment.

####Starting up the application
Starting up the application is fairly similar to what we have done before. This time however, we'll make use of the more **fluent API** of the *SpringApplicationBuilder*, which, as the name suggests, uses the builder pattern.

You'll see that we create an instance of the application and use the *.profiles(String[] profileNames*) method to active one or more active profiles.

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan
	public class ProfileApplication {
		public static void main(String[] args) throws Exception {
	        new SpringApplicationBuilder(ProfileApplication.class)
	                .profiles("test")
	                .run(args);
	    }
	}

####Required result

After starting up the application - if you didn't edit anything - using the following command:

	gradle bootRun

you should be seeing the following output:

	c.q.s.e.caching.mvc.GreetController: 
	You can say whatever you like, 
	but based on the active profiles (test) I can only say: 
	Hello test world!



###Testing the setup
How can we easily test this setup? How can we make sure that, when we active the test-profile, our production profile isn't loaded? How can we write automated, maintainable tests for this? 

> TODO: explain testing

###Other ways to activate profiles
In the example we previously explained, we added the profile in the startup method of our boot-application using the builder pattern, which was an equivalent of the 
	
	.setAdditionalProfiles(Stirng profileName)
 method. This is not the only way to activate a profile. 

By default, Spring will look in its current environment for the active profiles. 

> TODO: explain yml and application.properties way

> TODO: explain the jvm-argument way